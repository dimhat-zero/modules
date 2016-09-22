package com.jianla.faudit.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 问卷-答案表
 *
 * @author : zwj
 * @data : 2016/9/21
 */
@Entity
@Table(name="fa_answer")
public class Answer {

    @Id
    @GeneratedValue
    @Column(name="id",unique = true,nullable = false)
    private Long id;

    @Column(name="qn_id",nullable = false)
    private Long qnId;

    @Column(name="content",nullable = false)
    private String content;

    @Column(name="gmt_create",nullable = false)
    private Date gmtCreate;

    public Answer() {
    }

    public Answer(Long qnId, String content, Date gmtCreate) {
        this.qnId = qnId;
        this.content = content;
        this.gmtCreate = gmtCreate;
    }

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
