package com.jianla.faudit.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 问卷-问题表
 *
 * @author : zwj
 * @data : 2016/9/21
 */
@Entity
@Table(name="faudit_question")
public class Question {

    @Id
    @GeneratedValue
    @Column(name="id",nullable = false,unique = true)
    private Long id;

    @Column(name = "qn_id", nullable = false)
    private Long qnId;

    @Column(name="type",nullable = false)
    private Short type;

    @Column(name="content",nullable = false)
    private String content;

    @Column(name = "gmt_create",nullable = false)
    private Date  gmtCreate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQnId() {
        return qnId;
    }

    public void setQnId(Long qnId) {
        this.qnId = qnId;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}
