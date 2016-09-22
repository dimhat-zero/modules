package com.jianla.faudit.service;

import com.jianla.faudit.dto.QuestionDto;
import com.jianla.faudit.dto.QuestionType;
import com.jianla.faudit.dto.QuestionaireDto;
import com.jianla.faudit.entity.Questionaire;
import com.jianla.faudit.service.base.ServiceTestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zwj
 * @date 2016/9/21
 */
public class QuestionaireServiceTest extends ServiceTestBase{

    @Autowired
    private QuestionaireService qnService;

    //机构问卷列表
    @Test
    public void findByOrgId() throws Exception {
        List<Questionaire> list = qnService.findByOrgId(1L);
        logger.debug("{}",list);
    }

    //机构存问卷
    @Test
    public void create() throws Exception {
        List<QuestionDto> questions = new ArrayList<>();
        QuestionDto q1 = new QuestionDto("问题1", QuestionType.RADIO,new String[]{"选项1","选项2","选项3"});
        QuestionDto q2 = new QuestionDto("问题2", QuestionType.CHECK,new String[]{"选项21","选项22","选项33"});
        questions.add(q1);
        questions.add(q2);
        qnService.create(1L,"我的调查问卷","关于测试",questions);
    }

    //机构改问卷
    @Test
    public void update() throws Exception {
        List<QuestionDto> questions = new ArrayList<>();
        QuestionDto q1 = new QuestionDto("问题1修改", QuestionType.RADIO,new String[]{"选项1","选项2修改","选项3"});
        QuestionDto q2 = new QuestionDto("问题2修改", QuestionType.CHECK,new String[]{"选项21修改","选项22","选项33"});
        questions.add(q1);
        questions.add(q2);
        qnService.update(2L,"我的调查问卷修改","修改摘要",questions);
    }

    //机构删除问卷
    @Test
    public void delete() throws Exception {
        qnService.delete(2L);
    }

    //用户查找问卷
    @Test
    public void getDetailById() throws  Exception{
        QuestionaireDto dto = qnService.getDetailById(3L);
        logger.debug("{}",dto);
    }


}