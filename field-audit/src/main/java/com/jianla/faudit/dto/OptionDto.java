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

    private Boolean selected;//是否被选择

    private String remark;//用户自填内容

    public OptionDto(String content) {
        this.content = content;
    }

    public OptionDto(Long id) {
        this.id = id;
    }

    public OptionDto(Long id, String remark) {
        this.id = id;
        this.remark = remark;
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

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
        sb.append(", selected=").append(selected);
        sb.append(", remark='").append(remark).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
