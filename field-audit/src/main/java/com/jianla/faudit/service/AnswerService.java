package com.jianla.faudit.service;

import com.jianla.faudit.entity.Answer;

/**
 * @author : zwj
 * @data : 2016/9/21
 */
public interface AnswerService {

    /**
     * 提交答案
     * @param qnId 问卷id
     * @param content 问卷快照内容
     */
    void submitAnswer(Long qnId,String content);

    /**
     * 修改答案
     * @param answer
     */
    void modifyAnswer(Answer answer);
}
