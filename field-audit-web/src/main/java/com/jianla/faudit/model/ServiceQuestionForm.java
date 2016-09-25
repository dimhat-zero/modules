package com.jianla.faudit.model;

import java.util.List;

/**
 * @author : zwj
 * @data : 2016/9/25
 */
public class ServiceQuestionForm {

    private Long serviceId;

    private List<Long> questionIds;

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public List<Long> getQuestionIds() {
        return questionIds;
    }

    public void setQuestionIds(List<Long> questionIds) {
        this.questionIds = questionIds;
    }
}
