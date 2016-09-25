package com.jianla.faudit.model;

import com.jianla.faudit.dto.OptionDto;
import com.jianla.faudit.dto.QuestionDto;

import java.util.List;

/**
 * @author : zwj
 * @data : 2016/9/25
 */
public class QuestionAnswer extends QuestionDto {

    private Long id;

    private String content;

    private Short type;

    private Long orgId;

    private List<OptionDto> options;


    private List<Long> checkIds;//多选答案

    private Long radioId;//单选答案

    private String other;//问答 和 其他答案

    public List<Long> getCheckIds() {
        return checkIds;
    }

    public void setCheckIds(List<Long> checkIds) {
        this.checkIds = checkIds;
    }

    public Long getRadioId() {
        return radioId;
    }

    public void setRadioId(Long radioId) {
        this.radioId = radioId;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

}
