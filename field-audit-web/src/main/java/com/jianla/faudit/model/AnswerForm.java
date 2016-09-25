package com.jianla.faudit.model;

import java.util.List;

/**
 * @author : zwj
 * @data : 2016/9/25
 */
public class AnswerForm {

    private Long id;

    private Long fauditId;

    private Long serviceId;

    private List<QuestionAnswer> questions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFauditId() {
        return fauditId;
    }

    public void setFauditId(Long fauditId) {
        this.fauditId = fauditId;
    }

    public List<QuestionAnswer> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionAnswer> questions) {
        this.questions = questions;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }
}
