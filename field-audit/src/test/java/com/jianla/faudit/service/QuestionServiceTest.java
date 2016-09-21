package com.jianla.faudit.service;

import com.jianla.faudit.dto.QuestionDto;
import com.jianla.faudit.entity.Question;
import com.jianla.faudit.service.base.ServiceTestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author zwj
 * @date 2016/9/21
 */
public class QuestionServiceTest extends ServiceTestBase {

    @Autowired
    private QuestionService questionService;

    @Test
    public void create() throws Exception {
        List<String> options = new ArrayList<>();
        options.add("选项1");
        options.add("选项2");
        options.add("");//空选项 = 其他-用户自填
        Short type=0;
        String content="第一个问题";
        questionService.create(1L,content,type,options);
    }

    @Test
    public void update() throws Exception {
        List<String> options = new ArrayList<>();
        options.add("选项1");
        options.add("选项222");
        options.add("选项3");
        Short type=2;
        questionService.update(3L,"第一个问题修改",type,options);
    }

    @Test
    public void delete() throws Exception {

        questionService.delete(2L);
    }

    @Test
    public void getById() throws Exception {
        Question question = questionService.getById(3L);
        logger.debug("{}",question);
    }

    @Test
    public void getDetailById() throws Exception{
        QuestionDto questionDto = questionService.getDetailById(3L);
        logger.debug("{}",questionDto);
    }

    @Test
    public void findByOrgId() throws Exception {

        List<Question> questions = questionService.findByOrgId(1L);
        logger.debug("{}",questions);

    }

}