package com.jianla.faudit.service;

import com.jianla.faudit.service.base.ServiceTestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : zwj
 * @data : 2016/9/22
 */
public class FauditServiceTest extends ServiceTestBase {

    @Autowired
    private AnswerService answerService;

    /*
     * 我们已经收到了您的实地验厂申请单，为了能够更好的配合您，我们这里有一份自验单需要您的填写。
     * 1.完成申请单提交
     * 2.展示【自验单】
     * 3.提交【自验单】
     */
    @Test
    public void test() throws Exception{
        String content="";
        Long id=1L;
    }
}
