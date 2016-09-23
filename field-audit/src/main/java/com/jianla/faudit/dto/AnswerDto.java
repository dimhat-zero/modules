package com.jianla.faudit.dto;

import java.util.Date;
import java.util.List;

/**
 * @author : zwj
 * @data : 2016/9/22
 */
public class AnswerDto {

    private Long id;

    private List<QuestionDto> questionDtos;

    private List<QuestionAnswer> questionAnswers;

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

    public List<QuestionDto> getQuestionDtos() {
        return questionDtos;
    }

    public void setQuestionDtos(List<QuestionDto> questionDtos) {
        this.questionDtos = questionDtos;
    }

    public List<QuestionAnswer> getQuestionAnswers() {
        return questionAnswers;
    }

    public void setQuestionAnswers(List<QuestionAnswer> questionAnswers) {
        this.questionAnswers = questionAnswers;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}
