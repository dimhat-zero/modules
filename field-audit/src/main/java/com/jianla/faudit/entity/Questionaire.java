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
@Table(name="fa_questionaire")
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

    @Column(name="gmt_modify",nullable = false)
    private Date gmtModify;

    public Questionaire() {
    }

    public Questionaire(String title, String summary, Date gmtCreate, Long orgId) {
        this.title = title;
        this.summary = summary;
        this.gmtCreate = gmtCreate;
        this.orgId = orgId;
    }

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

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Questionaire{");
        sb.append("id=").append(id);
        sb.append(", orgId=").append(orgId);
        sb.append(", title='").append(title).append('\'');
        sb.append(", summary='").append(summary).append('\'');
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModify=").append(gmtModify);
        sb.append('}');
        return sb.toString();
    }
}
