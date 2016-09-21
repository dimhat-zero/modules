package com.jianla.faudit.entity;

import javax.persistence.*;

/**
 * 问题-选项表
 *
 * @author : zwj
 * @data : 2016/9/21
 */
@Entity
@Table(name = "faudit_option")
public class Option {

    @Id
    @GeneratedValue
    @Column(name="id",nullable = false,unique = true)
    private Long id;

    @Column(name="question_id",nullable = false)
    private Long questionId;

    @Column(name="content",nullable = false)
    private String content;

    public Option() {
    }

    public Option(String content, Long questionId) {
        this.content = content;
        this.questionId = questionId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
