package com.jianla.faudit.service;

import com.jianla.faudit.dto.OptionDto;
import com.jianla.faudit.dto.QuestionaireDto;
import com.jianla.faudit.service.base.ServiceTestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zwj
 * @data : 2016/9/22
 */
public class AnswerServiceTest extends ServiceTestBase {

    @Autowired
    private AnswerService answerService;

    @Test
    public void submit(){
        List<OptionDto> options = new ArrayList<>();
        options.add(new OptionDto(40L));
        options.add(new OptionDto(42L,"我自已填的"));
        answerService.submitAnswer(3L,options);
    }

    @Test
    public void modify(){
        List<OptionDto> options = new ArrayList<>();
        options.add(new OptionDto(43L));
        options.add(new OptionDto(42L,"我自已填的修改"));
        answerService.modifyAnswer(7L,options);
    }

    @Test
    public void getAnswerById(){

        QuestionaireDto dto = answerService.getAnswerById(7L);
        logger.debug("dto : {}",dto);
    }

}
