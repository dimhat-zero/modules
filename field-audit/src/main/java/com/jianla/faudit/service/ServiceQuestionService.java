package com.jianla.faudit.service;

import com.jianla.faudit.dto.QuestionDto;

import java.util.List;

/**
 * @author : zwj
 * @data : 2016/9/21
 */
public interface ServiceQuestionService {

    /**
     * 选择服务的问题组成
     */
    void add(Long serviceId, List<Long> questionIds);

    void add(Long serviceId,Long questionId);

    void deleteByServiceId(Long serviceId);

    List<QuestionDto> findQuestionsByServiceId(Long serviceId);
}
