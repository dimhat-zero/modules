package com.jianla.faudit.service;

import com.jianla.faudit.entity.Questionaire;

import java.util.List;

/**
 * @author : zwj
 * @data : 2016/9/21
 */
public interface QuestionaireService {

    void create(Questionaire questionaire);

    void update(Questionaire questionaire);

    void delete(Questionaire questionaire);

    Questionaire getById(Long id);

    List<Questionaire> findByOrgId(Long orgId);
}
