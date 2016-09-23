package com.jianla.faudit.service;

import com.jianla.faudit.dto.QuestionDto;
import com.jianla.faudit.service.base.ServiceTestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zwj
 * @data : 2016/9/23
 */
public class ServiceQuestionServiceTest extends ServiceTestBase {

    @Autowired
    private ServiceQuestionService serviceQuestionService;

    @Test
    public void add() throws Exception {
        List<Long> questionIds = new ArrayList<>();
        questionIds.add(16L);
        questionIds.add(18L);
        questionIds.add(19L);
        serviceQuestionService.add(1L,questionIds);
    }

    @Test
    public void deleteByServiceId() throws Exception {
        serviceQuestionService.deleteByServiceId(1L);
    }

    @Test
    public void findQuestionsByServiceId(){
        List<QuestionDto> list = serviceQuestionService.findQuestionsByServiceId(1L);
        logger.debug("{}",list);
    }

}