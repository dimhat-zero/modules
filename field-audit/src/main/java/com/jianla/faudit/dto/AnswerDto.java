package com.jianla.faudit.dto;

import java.util.Date;

/**
 * @author : zwj
 * @data : 2016/9/22
 */
public class AnswerDto {

    private Long id;

    private String content;

    private Date gmtCreate;

    private Long fauditId;

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
