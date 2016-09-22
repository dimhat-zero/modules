package com.jianla.faudit.dao.impl;

import com.jianla.dao.base.impl.BaseDaoImpl;
import com.jianla.faudit.dao.AnswerDao;
import com.jianla.faudit.entity.Answer;
import org.springframework.stereotype.Repository;

/**
 * @author : zwj
 * @data : 2016/9/21
 */
@Repository
public class AnswerDaoImpl extends BaseDaoImpl<Answer> implements AnswerDao {
    @Override
    public Answer getById(Long id) {
        return get(Answer.class,id);
    }
}
