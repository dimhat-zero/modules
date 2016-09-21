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

    private final short code;

    private final String name;

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
    public short getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "QuestionType{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }
}
