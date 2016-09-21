package com.jianla.faudit.entity;

import javax.persistence.*;

/**
 * 服务关联问卷表
 *
 * @author : zwj
 * @data : 2016/9/21
 */
@Entity
@Table(name="faudit_service_qn")
public class ServiceQn {

    @Id
    @GeneratedValue
    @Column(name="id",nullable = false,unique = true)
    private Long id;

    @Column(name="service_id",nullable = false)
    private Long serviceId;

    @Column(name="qn_id",nullable = false)
    private Long qnId;

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

    public Long getQnId() {
        return qnId;
    }

    public void setQnId(Long qnId) {
        this.qnId = qnId;
    }
}
