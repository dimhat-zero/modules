package com.jianla.faudit.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题类
 * <p>
 * 类替代类型码（枚举类或static final变量类）
 * 子类取代类型码（存在多态if-else，类型码会影响类的行为） 工厂函数中switch创建子类
 * 状态取代类型码（不能继承或状态会变动）在1的基础上，这个类是状态变成多态了
 * 以字段取代子类（子类只有返回常量类型码的功能，没有存在必要）
 * </p>
 * @author zwj
 * @date 2016/9/21
 */
public class QuestionDto {

    private Long id;

    private String content;

    private QuestionType type;

    private Long qnId;

    private List<OptionDto> options;

    public QuestionDto() {

    }

    public QuestionDto(String content, QuestionType type, List<String> optionStrs) {
        this.content = content;
        this.type = type;
        this.options = new ArrayList<>();
        for (String option : optionStrs) {
            this.options.add(new OptionDto(option));
        }
    }

    public QuestionDto(String content, QuestionType type, String[] optionStrs) {
        this.content = content;
        this.type = type;
        this.options = new ArrayList<>();
        for (String option : optionStrs) {
            this.options.add(new OptionDto(option));
        }
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OptionDto> getOptions() {
        return options;
    }

    public void setOptions(List<OptionDto> options) {
        this.options = options;
    }

    public Short getTypeCode(){
        return type.getCode();
    }

    public void setTypeCode(Short typecode){
        type = QuestionType.code(typecode);
    }

    @JSONField(serialize = false)
    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    @JSONField(serialize = false)
    public Long getQnId() {
        return qnId;
    }

    public void setQnId(Long qnId) {
        this.qnId = qnId;
    }

    @JSONField(serialize = false)
    public List<String> getOptionStrs(){
        List<String> list = new ArrayList<>();
        for (OptionDto option : options) {
            list.add(option.getContent());
        }
        return list;
    }

    public void setOptionStrs(List<String> optionStrs) {
        this.options = new ArrayList<>();
        for (String optionStr : optionStrs) {
            this.options.add(new OptionDto(optionStr));
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("QuestionDto{");
        sb.append("id=").append(id);
        sb.append(", content='").append(content).append('\'');
        sb.append(", type=").append(type);
        sb.append(", qnId=").append(qnId);
        sb.append(", options=").append(options);
        sb.append('}');
        return sb.toString();
    }
}
