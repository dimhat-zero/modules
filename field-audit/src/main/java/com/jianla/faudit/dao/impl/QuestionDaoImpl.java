package com.jianla.faudit.dao.impl;

import com.jianla.dao.base.impl.BaseDaoImpl;
import com.jianla.faudit.dao.QuestionDao;
import com.jianla.faudit.entity.Question;
import org.springframework.stereotype.Repository;

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


}
