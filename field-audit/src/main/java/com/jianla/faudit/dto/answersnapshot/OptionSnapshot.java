package com.jianla.faudit.dto.answersnapshot;

/**
 * @author : zwj
 * @data : 2016/9/21
 */
public class OptionSnapshot {

    private String content;

    private String other;//content为空时，用户自己填写的信息

    private Boolean selected;//是否被选择

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
}
