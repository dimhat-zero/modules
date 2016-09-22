package com.jianla.faudit.service.impl;

import com.jianla.faudit.dao.OptionDao;
import com.jianla.faudit.dao.QuestionDao;
import com.jianla.faudit.dto.OptionDto;
import com.jianla.faudit.dto.QuestionDto;
import com.jianla.faudit.dto.QuestionType;
import com.jianla.faudit.entity.Option;
import com.jianla.faudit.entity.Question;
import com.jianla.faudit.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : zwj
 * @data : 2016/9/21
 */
@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private OptionDao optionDao;


    @Override
    public void create(Long qnId,String content, Short type, List<String> options) {
        Question question = new Question(content,type,new Date(),qnId);
        questionDao.save(question);
        Long questionId = question.getId();
        logger.debug("create question[{}] success.",questionId);
        for (String optionStr : options) {
            Option option = new Option(optionStr,questionId);
            optionDao.save(option);
        }
    }

    @Override
    public void update(Long id, String content, Short type, List<String> options) {
        Question question = questionDao.getById(id);
        if(question==null) return;
        question.setContent(content);
        question.setType(type);
        //delete old options
        Long questionId = question.getId();
        optionDao.deleteByQuestionId(questionId);
        //insert new options
        for (String optionStr : options) {
            Option option = new Option(optionStr,questionId);
            optionDao.save(option);
        }
    }

    @Override
    public void delete(Long id) {
        Question question = questionDao.getById(id);
        if(question!=null){
            this.delete(question);
        }
    }

    @Override
    public void delete(Question question) {
        //delete question options
        optionDao.deleteByQuestionId(question.getId());

        questionDao.delete(question);
    }

    @Override
    public Question getById(Long id) {
        Question question = questionDao.getById(id);
        return question;
    }

    @Override
    public QuestionDto getDetailById(Long id) {
        Question question = questionDao.getById(id);
        if(question==null) return null;
        QuestionDto dto = new QuestionDto();
        BeanUtils.copyProperties(question,dto,new String[]{"type"});
        dto.setType(QuestionType.code(question.getType()));
        //find options
        dto.setOptions(this.findOptionsByQuestionId(question.getId()));
        return dto;
    }

    private List<OptionDto> findOptionsByQuestionId(Long questionId){
        List<Option> options = optionDao.findByQuestionId(questionId);
        List<OptionDto> optionDtos = new ArrayList<>();
        for (Option option : options) {
            OptionDto dto = new OptionDto();
            BeanUtils.copyProperties(option,dto);
            optionDtos.add(dto);
        }
        return optionDtos;
    }

    @Override
    public List<Question> findByOrgId(Long orgId) {
        return questionDao.find("from Question where orgId = ?",new Object[]{orgId});
    }

    @Override
    public List<QuestionDto> findDetailByIds(List<Long> questionIds) {
        List<QuestionDto> list = new ArrayList<>();
        for (Long questionId : questionIds) {
            list.add(this.getDetailById(questionId));
        }
        return list;
    }

    @Override
    public void deleteByQnId(Long qnId) {
        List<Long> questionIds = this.findIdsByQnId(qnId);
        for (Long questionId : questionIds) {
            this.delete(questionId);
        }
    }

    @Override
    public List<Long> findIdsByQnId(Long qnId){
        List<Long> questionIds = questionDao.findIdsByQnId(qnId);
        return questionIds;
    }

    @Override
    public List<QuestionDto> findByQnId(Long qnId) {
        return findDetailByIds(this.findIdsByQnId(qnId));
    }
}
