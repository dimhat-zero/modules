package com.jianla.faudit.service;

import com.jianla.faudit.dto.QuestionaireDto;
import com.jianla.faudit.entity.Questionaire;
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
public class QuestionaireServiceTest extends ServiceTestBase{

    @Autowired
    private QuestionaireService qnService;

    @Test
    public void create() throws Exception {
        List<Long> questionIds = new ArrayList<>();
        questionIds.add(3L);
        questionIds.add(4L);
        qnService.create(1L,"我的调查问卷","关于测试",questionIds);
    }

    @Test
    public void update() throws Exception {
        List<Long> questionIds = new ArrayList<>();
        questionIds.add(5L);
        questionIds.add(6L);
        qnService.update(1L,"修改标题","修改摘要",questionIds);
    }

    @Test
    public void delete() throws Exception {
        qnService.delete(1L);
    }

    @Test
    public void getById() throws Exception {
        Questionaire questionaire = qnService.getById(1L);
        logger.debug("{}",questionaire);
    }

    @Test
    public void getDetailById() throws  Exception{
        QuestionaireDto dto = qnService.getDetailById(1L);
        logger.debug("{}",dto);
    }

    @Test
    public void findByOrgId() throws Exception {
        List<Questionaire> list = qnService.findByOrgId(1L);
        logger.debug("{}",list);
    }

}