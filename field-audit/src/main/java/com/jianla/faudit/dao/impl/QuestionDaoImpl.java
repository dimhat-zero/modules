package com.jianla.faudit.dao.impl;

import com.jianla.dao.base.BaseDaoI;
import com.jianla.dao.base.impl.BaseDaoImpl;
import com.jianla.faudit.dao.QuestionDao;
import com.jianla.faudit.entity.Question;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zwj
 * @data : 2016/9/21
 */
@Repository
public class QuestionDaoImpl extends BaseDaoImpl<Question> implements QuestionDao {
    @Override
    public Question getById(Long id) {
        return get(Question.class,id);
    }

    @Override
    public List<Question> findByIds(List<Long> questionIds) {
        List<Question> questions = new ArrayList<>();
        for (Long questionId : questionIds) {
            Question question = getById(questionId);
            questions.add(question);
        }
        return questions;
    }
}
