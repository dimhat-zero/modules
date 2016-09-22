package com.jianla.faudit.service.impl;

import com.alibaba.fastjson.JSON;
import com.jianla.faudit.dao.AnswerDao;
import com.jianla.faudit.dto.OptionDto;
import com.jianla.faudit.dto.QuestionDto;
import com.jianla.faudit.dto.QuestionaireDto;
import com.jianla.faudit.entity.Answer;
import com.jianla.faudit.exception.FauditException;
import com.jianla.faudit.service.AnswerService;
import com.jianla.faudit.service.QuestionaireService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 在服务器端进行选择：比较复杂但安全
 * 另一种是在浏览器中处理，返回字符串
 * @author : zwj
 * @data : 2016/9/22
 */
@Service
@Transactional
public class AnswerServiceImpl implements AnswerService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AnswerDao answerDao;

    @Autowired
    private QuestionaireService questionaireService;

    @Override
    public Answer submitAnswer(Long qnId, List<OptionDto> options) {
        QuestionaireDto questionaireDto = questionaireService.getDetailById(qnId);
        if(questionaireDto==null){
            throw new FauditException("问卷不存在");
        }
        return snapshotAnswer(questionaireDto,options);
    }

    @Override
    public Answer submitAnswer(Long qnId, List<OptionDto> options, long version) {
        QuestionaireDto questionaireDto = questionaireService.getDetailById(qnId);
        if(questionaireDto==null){
            throw new FauditException("问卷不存在");
        }
        long dbVersion = questionaireDto.getGmtModify().getTime();
        if(dbVersion!=version){
            throw new FauditException("问卷已更新，请刷新页面");
        }
        return snapshotAnswer(questionaireDto,options);
    }

    private Answer snapshotAnswer(QuestionaireDto questionaireDto, List<OptionDto> options){
        this.selectOptions(questionaireDto,options);
        //保存
        String snapshotStr = this.snapshot(questionaireDto);
        Answer answer = new Answer(questionaireDto.getId(),snapshotStr,new Date());
        answerDao.save(answer);
        return answer;
    }

    //自动选择选项
    private void selectOptions(QuestionaireDto questionaireDto,List<OptionDto> options){
        //构建选项map
        Map<Long,OptionDto> optionMap = new HashMap<>();
        for (QuestionDto questionDto : questionaireDto.getQuestions()) {
            for (OptionDto optionDto : questionDto.getOptions()) {
                optionDto.setSelected(false);
                optionDto.setRemark(null);
                optionMap.put(optionDto.getId(),optionDto);
            }
        }
        //选择选项
        for (OptionDto option : options) {
            OptionDto optionDto = optionMap.get(option.getId());
            if(optionDto!=null){
                optionDto.setSelected(true);
                if(optionDto.custom()){
                    optionDto.setRemark(option.getRemark());
                }
            }
        }
    }

    @Override
    public void modifyAnswer(Long id,List<OptionDto> options) {
        Answer answer = answerDao.getById(id);
        QuestionaireDto questionaireDto = this.restore(answer.getContent());
        this.selectOptions(questionaireDto,options);
        //保存
        String snapshotStr = this.snapshot(questionaireDto);
        answer.setContent(snapshotStr);
        answerDao.update(answer);

    }

    private String snapshot(Object obj){
        return JSON.toJSONString(obj);
    }

    private QuestionaireDto restore(String snapshotStr){
        QuestionaireDto questionaireDto = JSON.parseObject(snapshotStr, QuestionaireDto.class);
        return questionaireDto;
    }

    @Override
    public QuestionaireDto getAnswerById(Long id) {
        Answer answer = answerDao.getById(id);
        return this.restore(answer.getContent());
    }
}
