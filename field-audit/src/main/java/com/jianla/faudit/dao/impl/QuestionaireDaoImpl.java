package com.jianla.faudit.dao.impl;

import com.jianla.dao.base.BaseDaoI;
import com.jianla.dao.base.impl.BaseDaoImpl;
import com.jianla.faudit.dao.QuestionaireDao;
import com.jianla.faudit.entity.Questionaire;
import org.springframework.stereotype.Repository;

/**
 * @author : zwj
 * @data : 2016/9/21
 */
@Repository
public class QuestionaireDaoImpl extends BaseDaoImpl<Questionaire> implements QuestionaireDao {


    @Override
    public Questionaire getById(Long id) {
        return get(Questionaire.class,id);
    }
}
