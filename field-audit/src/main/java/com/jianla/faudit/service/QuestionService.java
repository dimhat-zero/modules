package com.jianla.faudit.service;

import com.jianla.faudit.entity.Option;
import com.jianla.faudit.entity.Question;

import java.util.List;

/**
 * 问题服务
 *
 * @author : zwj
 * @data : 2016/9/21
 */
public interface QuestionService {

    void create(Question question);

    void create(Question question,List<Option> options);

    void update(Question question);

    void update(Question question,List<Option> options);

    void delete(Question question);

    Question getById(Long id);

    List<Question> findByOrgId(Long orgId);

}
