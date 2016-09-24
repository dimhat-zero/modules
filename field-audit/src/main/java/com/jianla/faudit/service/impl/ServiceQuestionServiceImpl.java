package com.jianla.faudit.service.impl;

import com.jianla.faudit.dao.ServiceQuestionDao;
import com.jianla.faudit.dto.QuestionDto;
import com.jianla.faudit.entity.ServiceQuestion;
import com.jianla.faudit.service.QuestionService;
import com.jianla.faudit.service.ServiceQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zwj
 * @data : 2016/9/23
 */
@Service
@Transactional
public class ServiceQuestionServiceImpl implements ServiceQuestionService {

    @Autowired
    private ServiceQuestionDao serviceQuestionDao;

    @Autowired
    private QuestionService questionService;

    @Override
    public void add(Long serviceId, List<Long> questionIds) {
        for (Long questionId : questionIds) {
            this.add(serviceId,questionId);
        }
    }

    @Override
    public void add(Long serviceId, Long questionId) {
        ServiceQuestion o = new ServiceQuestion(serviceId,questionId);
        serviceQuestionDao.save(o);
    }

    @Override
    public void deleteByServiceId(Long serviceId) {
        serviceQuestionDao.executeHql("delete from ServiceQuestion where serviceId = ?",new Object[]{serviceId});
    }

    @Override
    public List<QuestionDto> findQuestionsByServiceId(Long serviceId) {
        String hql="from ServiceQuestion where serviceId = ?";
        List<ServiceQuestion> serviceQuestions = serviceQuestionDao.find(hql, new Object[]{serviceId});
        List<QuestionDto> result = new ArrayList<>();
        for (ServiceQuestion serviceQuestion : serviceQuestions) {
            result.add(questionService.getDetailById(serviceQuestion.getQuestionId()));
        }
        return result;
    }

    @Override
    public List<Long> findServiceIdByQuestionId(Long id) {
        return serviceQuestionDao.findServiceIdByQuestionId(id);
    }
}
