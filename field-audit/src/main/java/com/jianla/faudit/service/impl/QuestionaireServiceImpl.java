package com.jianla.faudit.service.impl;

import com.jianla.faudit.dao.QuestionaireDao;
import com.jianla.faudit.dto.QuestionDto;
import com.jianla.faudit.dto.QuestionaireDto;
import com.jianla.faudit.entity.Questionaire;
import com.jianla.faudit.service.QuestionService;
import com.jianla.faudit.service.QuestionaireService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private QuestionaireDao questionaireDao;
    @Autowired
    private QuestionService questionService;

    @Override
    public void create(Long orgId, String title, String summary, List<QuestionDto> questions) {
        Questionaire questionaire = new Questionaire(title,summary,new Date(),orgId);
        questionaireDao.save(questionaire);
        Long questionaireId = questionaire.getId();
        //insert questions
        for (QuestionDto question : questions) {
            questionService.create(questionaireId,question.getContent(),question.getType().getCode(),question.getOptionStrs());
        }
        logger.debug("创建问卷成功！id= {}",questionaireId);
    }

    @Override
    public void update(Long id, String title, String summary, List<QuestionDto> questions) {
        Questionaire questionaire = questionaireDao.getById(id);
        if(questionaire==null) return;
        questionaire.setTitle(title);
        questionaire.setSummary(summary);
        questionaireDao.save(questionaire);
        //delete old questions
        questionService.deleteByQnId(id);
        //insert questions
        for (QuestionDto question : questions) {
            questionService.create(id,question.getContent(),question.getType().getCode(),question.getOptionStrs());
        }
    }

    @Override
    public void delete(Questionaire questionaire) {
        //delete all qn questions
        questionService.deleteByQnId(questionaire.getId());
        //delete self
        questionaireDao.delete(questionaire);
    }

    @Override
    public void delete(Long id) {
        Questionaire questionaire = questionaireDao.getById(id);
        if(questionaire!=null){
            this.delete(questionaire);
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
        List<QuestionDto> questions = questionService.findByQnId(id);
        dto.setQuestions(questions);
        return dto;
    }

    @Override
    public List<Questionaire> findByOrgId(Long orgId) {
        return questionaireDao.find("from Questionaire where orgId = ?",new Object[]{orgId});
    }
}
