package com.jianla.faudit.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 调查问卷表
 *
 * @author : zwj
 * @data : 2016/9/21
 */
@Entity
@Table(name="faudit_questionaire")
public class Questionaire {

    @Id
    @GeneratedValue
    @Column(name = "id",nullable = false,unique = true)
    private Long id;

    @Column(name="org_id",nullable = false)
    private Long orgId;

    @Column(name="title",nullable = false)
    private String title;

    @Column(name="summary")
    private String summary;

    @Column(name="gmt_create",nullable = false)
    private Date gmtCreate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}
