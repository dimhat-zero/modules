package com.jianla.faudit.model;

import com.jianla.faudit.dto.QuestionDto;

import java.util.List;

/**
 * @author : zwj
 * @data : 2016/9/22
 */
public class QuestionaireForm {

    private Long id;

    private String title;

    private String summary;

    private List<QuestionDto> questions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<QuestionDto> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDto> questions) {
        this.questions = questions;
    }
}
