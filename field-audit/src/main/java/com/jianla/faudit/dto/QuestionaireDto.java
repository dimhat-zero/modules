package com.jianla.faudit.dto;

import com.jianla.faudit.dao.QuestionDao;

import java.util.List;

/**
 * @author zwj
 * @date 2016/9/21
 */
public class QuestionaireDto {

    private Long id;

    private String title;

    private String summary;

    private Long orgId;

    private List<QuestionDto> questions;

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

    public List<QuestionDto> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDto> questions) {
        this.questions = questions;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "QuestionaireDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", orgId=" + orgId +
                ", questions=" + questions +
                '}';
    }
}
