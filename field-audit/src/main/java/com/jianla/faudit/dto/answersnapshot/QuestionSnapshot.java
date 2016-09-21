package com.jianla.faudit.dto.answersnapshot;

import java.util.List;

/**
 * @author : zwj
 * @data : 2016/9/21
 */
public class QuestionSnapshot {

    private String content;

    private List<OptionSnapshot> options;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<OptionSnapshot> getOptions() {
        return options;
    }

    public void setOptions(List<OptionSnapshot> options) {
        this.options = options;
    }
}
