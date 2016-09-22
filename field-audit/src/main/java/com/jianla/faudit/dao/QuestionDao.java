package com.jianla.faudit.dao;

import com.jianla.dao.base.BaseDaoI;
import com.jianla.faudit.entity.Question;

import java.util.List;

/**
 * 问卷-问题dao
 *
 * @author : zwj
 * @data : 2016/9/21
 */
public interface QuestionDao extends BaseDaoI<Question> {
    Question getById(Long id);

    List<Question> findByIds(List<Long> questionIds);

    List<Long> findIdsByQnId(Long qnId);
}
