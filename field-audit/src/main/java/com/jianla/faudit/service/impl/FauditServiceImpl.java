package com.jianla.faudit.service.impl;

import com.jianla.faudit.dao.FauditDao;
import com.jianla.faudit.dto.OptionDto;
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
    }

    @Override
    public void modifyAnswer(Long id, Long qnId, List<OptionDto> options) {

    }
}
