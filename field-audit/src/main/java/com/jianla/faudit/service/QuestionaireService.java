package com.jianla.faudit.service;

import com.jianla.faudit.dto.QuestionaireDto;
import com.jianla.faudit.entity.Questionaire;

import java.util.List;

/**
 * @author : zwj
 * @data : 2016/9/21
 */
public interface QuestionaireService {

    /**
     * 创建问卷
     * @param orgId 创建人
     * @param title 标题
     * @param summary 摘要
     * @param questionIds 问题集合
     */
    void create(Long orgId,String title,String summary, List<Long> questionIds);

    void update(Long id,String title,String summary, List<Long> questionIds);

    void delete(Questionaire questionaire);

    void delete(Long id);

    Questionaire getById(Long id);

    QuestionaireDto getDetailById(Long id);

    List<Questionaire> findByOrgId(Long orgId);
}
