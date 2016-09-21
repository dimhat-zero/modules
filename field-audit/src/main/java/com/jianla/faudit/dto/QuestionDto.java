package com.jianla.faudit.dto;

import com.jianla.faudit.entity.Question;

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

    private Long orgId;

    private List<String> options;

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

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = QuestionType.code(type);
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    @Override
    public String toString() {
        return "QuestionDto{" +
                "content='" + content + '\'' +
                ", id=" + id +
                ", type=" + type +
                ", orgId=" + orgId +
                ", options=" + options +
                '}';
    }
}
