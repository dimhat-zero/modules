package com.jianla.faudit.service.impl;

import com.jianla.faudit.dao.AnswerDao;
import com.jianla.faudit.dto.AnswerDto;
import com.jianla.faudit.entity.Answer;
import com.jianla.faudit.service.AnswerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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

    private static final String QUESTIONS = "questions";
    private static final String ANSWERS = "answers";

    @Override
    public void submit(Long fauditId,String content) {

        Answer answer = new Answer();
        answer.setFauditId(fauditId);
        answer.setGmtCreate(new Date());
        answer.setContent(content);

        answerDao.save(answer);
    }

    @Override
    public void modify(Long id, String content) {
        Answer answer = answerDao.getById(id);
        if(answer!=null){
            answer.setContent(content);
            answerDao.save(answer);
        }
    }

    @Override
    public AnswerDto getById(Long id) {
        Answer answer = answerDao.getById(id);
        if(answer==null) return null;
        return trans(answer);
    }

    @Override
    public void deleteById(Long id) {
        Answer answer = answerDao.getById(id);
        if(answer!=null) {
            answerDao.delete(answer);
        }
    }

    private AnswerDto trans(Answer answer){
        AnswerDto dto = new AnswerDto();
        BeanUtils.copyProperties(answer,dto);
        return dto;
    }

}
