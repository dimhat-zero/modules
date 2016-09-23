package com.jianla.faudit.entity;

import javax.persistence.*;

/**
 * 服务关联问题表
 *
 * @author : zwj
 * @data : 2016/9/21
 */
@Entity
@Table(name="fa_service_question")
public class ServiceQuestion {

    @Id
    @GeneratedValue
    @Column(name="id",nullable = false,unique = true)
    private Long id;

    @Column(name="service_id",nullable = false)
    private Long serviceId;

    @Column(name="question_id",nullable = false)
    private Long questionId;

    public ServiceQuestion(Long serviceId, Long questionId) {
        this.serviceId=serviceId;
        this.questionId=questionId;
    }

    public ServiceQuestion() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
}
