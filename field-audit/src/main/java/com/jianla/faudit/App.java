package com.jianla.faudit;

import com.alibaba.fastjson.JSON;
import com.jianla.faudit.entity.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by think on 2016/9/21.
 */
public class App {

    public static void main(String[] args) {
        Question question = new Question();
        question.setId(1L);
        question.setQnId(null);
        System.out.println(JSON.toJSON(question));
    }

    void function1(){
        String[] a={"a","b","c"};
        List<String> strings = Arrays.asList(a);
        strings.add("d");
        //不支持的操作
        List<String> list = new ArrayList<>();
        Collections.addAll(list, a);
        list.add("d");//ok
    }
}
