package com.jianla.faudit.service;

import com.jianla.faudit.dto.QuestionDto;
import com.jianla.faudit.dto.QuestionType;
import com.jianla.faudit.entity.Question;
import com.jianla.faudit.service.base.ServiceTestBase;
import com.jianla.model.base.Page;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zwj
 * @data : 2016/9/23
 */
public class QuestionServiceTest extends ServiceTestBase {

    @Autowired
    private QuestionService questionService;

    //列表查询问题
    @Test
    public void list(){
        Page page = new Page<>();
        QuestionDto question = new QuestionDto();
        page = questionService.find(page,question);
        logger.debug("page:{}",page);
    }

    //创建一个问题
    @Test
    public void create(){
        List<String> options = new ArrayList<>();
        options.add("选项1");
        options.add("选项2");
        questionService.create(1L,"我的问题", QuestionType.RADIO.getCode(),options);
    }

    @Test
    public void addData(){
        for(int i = 0;i<100;i++){
            List<String> options = new ArrayList<>();
            options.add("是");
            options.add("否");
            questionService.create(1L,"我的问题"+i, QuestionType.RADIO.getCode(),options);
        }
    }

    //查看一个问题
    @Test
    public void getById(){
        Question question = questionService.getById(15L);
        logger.debug("{}",question);
    }

    @Test
    public void getDetailById(){
        QuestionDto question = questionService.getDetailById(15L);
        logger.debug("{}",question);
    }

    //修改一个问题
    @Test
    public void update(){
        List<String> options = new ArrayList<>();
        options.add("选项1修改");
        options.add("选项2修改");
        questionService.update(15L,"我的问题修改",QuestionType.CHECK.getCode(),options);
    }

    //删除一个问题
    @Test
    public void delete(){
        questionService.delete(15L);
    }

}
