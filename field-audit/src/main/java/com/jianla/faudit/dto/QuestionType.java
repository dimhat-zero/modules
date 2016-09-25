package com.jianla.faudit.dto;

/**
 * 问题类型
 * @author zwj
 * @date 2016/9/21
 */
public class QuestionType {

    public static final QuestionType RADIO=new QuestionType(0,"单选");//单选

    public static final QuestionType CHECK = new QuestionType(1,"多选");//多选

    public static final QuestionType QA =new QuestionType(2,"问答");//问答

    //枚举所有类型，跟下标对应
    private static final QuestionType[] values = {RADIO,CHECK,QA};

    private Short code;

    private String name;

    /*
     * 序列化妥协（无参构造和set方法）
     */
    public QuestionType() {
    }

    public void setCode(Short code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    //私有构造外部无法创建
    private QuestionType(int code,String name) {
        this.code = (short)code;
        this.name = name;
    }

    //类型 对应 对象下标
    public static QuestionType code(short arg){
        return values[arg];
    }

    //只提供getter方法
    public Short getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("QuestionType{");
        sb.append("code=").append(code);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
