package com.jianla.faudit.model;

import java.util.List;

/**
 * @author : zwj
 * @data : 2016/9/23
 */
public class QuestionForm {

    private Long id;

    private String content;

    private Short type;

    private List<String> options;

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

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}
