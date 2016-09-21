package com.jianla.faudit.service.impl;

import com.jianla.faudit.dao.QnQuestionDao;
import com.jianla.faudit.dao.QuestionDao;
import com.jianla.faudit.dao.QuestionaireDao;
import com.jianla.faudit.dto.QuestionDto;
import com.jianla.faudit.dto.QuestionaireDto;
import com.jianla.faudit.entity.QnQuestion;
import com.jianla.faudit.entity.Question;
import com.jianla.faudit.entity.Questionaire;
import com.jianla.faudit.service.QuestionService;
import com.jianla.faudit.service.QuestionaireService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author zwj
 * @date 2016/9/21
 */
@Service
@Transactional
public class QuestionaireServiceImpl implements QuestionaireService {
    @Autowired
    private QuestionaireDao questionaireDao;
    @Autowired
    private QnQuestionDao qnQuestionDao;
    @Autowired
    private QuestionService questionService;

    @Override
    public void create(Long orgId, String title, String summary, List<Long> questionIds) {
        Questionaire questionaire = new Questionaire(title,summary,new Date(),orgId);
        questionaireDao.save(questionaire);
        Long questionaireId = questionaire.getId();
        //insert questions
        for (Long questionId : questionIds) {
            QnQuestion qnQuestion = new QnQuestion(questionaireId,questionId);
            qnQuestionDao.save(qnQuestion);
        }
    }

    @Override
    public void update(Long id, String title, String summary, List<Long> questionIds) {
        Questionaire questionaire = questionaireDao.getById(id);
        if(questionaire==null) return;
        questionaire.setTitle(title);
        questionaire.setSummary(summary);
        questionaireDao.save(questionaire);
        //delete old questions
        qnQuestionDao.deleteByQnId(id);
        //insert questions
        for (Long questionId : questionIds) {
            QnQuestion qnQuestion = new QnQuestion(id,questionId);
            qnQuestionDao.save(qnQuestion);
        }
    }

    @Override
    public void delete(Questionaire questionaire) {
        questionaireDao.delete(questionaire);
    }

    @Override
    public void delete(Long id) {
        Questionaire questionaire = questionaireDao.getById(id);
        if(questionaire!=null){
            this.delete(questionaire);
            //delete qn-question
            qnQuestionDao.deleteByQnId(id);
        }
    }

    @Override
    public Questionaire getById(Long id) {
        return questionaireDao.getById(id);
    }

    @Override
    public QuestionaireDto getDetailById(Long id) {
        Questionaire questionaire = questionaireDao.getById(id);
        if(questionaire==null) return null;

        QuestionaireDto dto = new QuestionaireDto();
        BeanUtils.copyProperties(questionaire,dto);
        //find questions
        List<Long> questionIds = qnQuestionDao.findQuestionIdsByQnId(questionaire.getId());
        List<QuestionDto> questions = questionService.findDetailByIds(questionIds);
        dto.setQuestions(questions);
        return dto;
    }

    @Override
    public List<Questionaire> findByOrgId(Long orgId) {
        return questionaireDao.find("from Questionaire where orgId = ?",new Object[]{orgId});
    }
}
