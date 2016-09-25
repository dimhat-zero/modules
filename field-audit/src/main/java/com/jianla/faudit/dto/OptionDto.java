package com.jianla.faudit.dto;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 选择的选项
 * @author : zwj
 * @data : 2016/9/22
 */
public class OptionDto {

    private Long id;

    private String content;//选项内容，如果为空表示用户自选

    private Long questionId;

    public OptionDto(String content) {
        this.content = content;
    }

    public OptionDto(Long id) {
        this.id = id;
    }

    public OptionDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @JSONField(serialize = false)
    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }


    //是否用户自定义填写
    public boolean custom(){
        return (content==null||content.equals(""));
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OptionDto{");
        sb.append("id=").append(id);
        sb.append(", content='").append(content).append('\'');
        sb.append(", questionId=").append(questionId);
        sb.append('}');
        return sb.toString();
    }
}
