package com.jianla.faudit.dao;

import com.jianla.dao.base.BaseDaoI;
import com.jianla.faudit.entity.Questionaire;

/**
 * 问卷dao
 *
 * @author : zwj
 * @data : 2016/9/21
 */
public interface QuestionaireDao extends BaseDaoI<Questionaire> {


    Questionaire getById(Long id);
}
