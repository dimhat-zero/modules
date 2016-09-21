package com.jianla.faudit.entity;

import javax.persistence.*;

/**
 * @author : zwj
 * @date : 2016/9/21
 */
@Entity
@Table(name="faudit_qn_question")
public class QnQuestion {

    @Id
    @GeneratedValue
    @Column(name="id",nullable = false,unique = true)
    private Long id;

    @Column(name="qn_id",nullable = false)
    private Long qnId;

    @Column(name="question_id",nullable = false)
    private Long questionId;

    public QnQuestion(Long questionaireId, Long questionId) {
        this.qnId =questionaireId;
        this.questionId = questionId;
    }

    public QnQuestion() {
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

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
}
