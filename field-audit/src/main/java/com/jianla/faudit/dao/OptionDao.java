package com.jianla.faudit.dao;

import com.jianla.dao.base.BaseDaoI;
import com.jianla.faudit.entity.Option;

import java.util.List;

/**
 * 问题-选项dao
 *
 * @author : zwj
 * @data : 2016/9/21
 */
public interface OptionDao  extends BaseDaoI<Option>{
    void deleteByQuestionid(Long questionId);

    List<String> findContentByQuestionId(Long id);
}
