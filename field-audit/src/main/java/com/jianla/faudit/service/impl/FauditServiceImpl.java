package com.jianla.faudit.service.impl;

import com.jianla.faudit.dao.FauditDao;
import com.jianla.faudit.dto.OptionDto;
import com.jianla.faudit.entity.Answer;
import com.jianla.faudit.entity.Faudit;
import com.jianla.faudit.service.AnswerService;
import com.jianla.faudit.service.FauditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : zwj
 * @data : 2016/9/22
 */
@Service
@Transactional
public class FauditServiceImpl implements FauditService{

    @Autowired
    private FauditDao fauditDao;

    @Autowired
    private AnswerService answerService;

    @Override
    public Faudit createFaudit(Long userId) {
        return null;
    }

    @Override
    public void submitAnswer(Long id, Long qnId, List<OptionDto> options) {
        //1. 提交问卷答案
        Answer answer = answerService.submitAnswer(qnId, options);
        //2. 关联 验厂单 和 问卷
        Faudit faudit = fauditDao.get(Faudit.class,id);
        faudit.setAnswerId(answer.getId());

        fauditDao.update(faudit);
    }

    @Override
    public void modifyAnswer(Long id, Long qnId, List<OptionDto> options) {
        Faudit faudit = fauditDao.get(Faudit.class,id);
        //修改问卷答案
         answerService.modifyAnswer(faudit.getAnswerId(), options);

    }
}
