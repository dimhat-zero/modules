package com.jianla.faudit.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 答案表
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

    @Column(name="content",nullable = false)
    private String content;

    @Column(name="faudit_id")
    private Long fauditId;

    @Column(name="gmt_create",nullable = false)
    private Date gmtCreate;

    public Answer() {
    }

    public Answer(Long fauditId,String content, Date gmtCreate) {
        this.fauditId =fauditId;
        this.content = content;
        this.gmtCreate = gmtCreate;
    }

    public Long getFauditId() {
        return fauditId;
    }

    public void setFauditId(Long fauditId) {
        this.fauditId = fauditId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
