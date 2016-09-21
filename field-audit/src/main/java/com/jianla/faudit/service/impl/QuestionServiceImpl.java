package com.jianla.faudit.service.impl;

import com.jianla.faudit.dao.OptionDao;
import com.jianla.faudit.dao.QuestionDao;
import com.jianla.faudit.entity.Option;
import com.jianla.faudit.entity.Question;
import com.jianla.faudit.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void create(Question question) {
        questionDao.save(question);
    }

    @Override
    public void create(Question question, List<Option> options) {
        questionDao.save(question);
        Long questionId = question.getId();
        logger.debug("create question[{}] success.",questionId);
        for (Option option : options) {
            option.setQuestionId(questionId);
            optionDao.save(option);
        }
    }

    @Override
    public void update(Question question) {
        questionDao.update(question);
    }

    @Override
    public void update(Question question, List<Option> options) {
        questionDao.update(question);
        Long questionId = question.getId();
        //delete all old options
        optionDao.deleteByQuestionid(questionId);
        //insert new options
        for (Option option : options) {
            option.setQuestionId(questionId);
            optionDao.save(option);
        }
    }

    @Override
    public void delete(Question question) {
        questionDao.delete(question);
        //delete question options
        optionDao.deleteByQuestionid(question.getId());
    }

    @Override
    public Question getById(Long id) {
        Question question = questionDao.get(Question.class, id);
        return question;
    }

    @Override
    public List<Question> findByOrgId(Long orgId) {
        return questionDao.find("from Question where orgId = ?",new Object[]{orgId});
    }
}
