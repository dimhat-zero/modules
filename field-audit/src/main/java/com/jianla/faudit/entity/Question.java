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

    @Column(name="org_id",nullable = false)
    private Long orgId;

    @Column(name="type",nullable = false)
    private Short type;

    @Column(name="content",nullable = false)
    private String content;

    @Column(name = "gmt_create",nullable = false)
    private Date  gmtCreate;

    public Question() {
    }

    public Question(String content, Short type, Date gmtCreate,Long orgId) {
        this.content = content;
        this.gmtCreate = gmtCreate;
        this.type = type;
        this.orgId = orgId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    @Override
    public String toString() {
        return "Question{" +
                "content='" + content + '\'' +
                ", id=" + id +
                ", orgId=" + orgId +
                ", type=" + type +
                ", gmtCreate=" + gmtCreate +
                '}';
    }
}
