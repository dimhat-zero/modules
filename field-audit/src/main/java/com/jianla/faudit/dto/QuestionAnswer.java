package com.jianla.faudit.dto;

import java.util.List;

/**
 * 选择后的问题
 * @author : zwj
 * @data : 2016/9/23
 */
public class QuestionAnswer {

    private Long questionId;

    private List<Long> optionIds;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public List<Long> getOptionIds() {
        return optionIds;
    }

    public void setOptionIds(List<Long> optionIds) {
        this.optionIds = optionIds;
    }
}
