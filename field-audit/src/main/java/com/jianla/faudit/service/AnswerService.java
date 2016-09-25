package com.jianla.faudit.service;

import com.jianla.faudit.dto.AnswerDto;

/**
 * @author : zwj
 * @data : 2016/9/21
 */
public interface AnswerService {

    /**
     * 提交问卷回答
     */
    void submit(Long fauditId,String content);

    /**
     * 修改答案
     * @param id
     * @param content
     */
    void modify(Long id, String content);

    /**
     * 得到一份答案
     * @param id
     * @return 答案对象
     */
    AnswerDto getById(Long id);

    /**
     * 删除一份答案 机构操作
     * @param id
     */
    void deleteById(Long id);

}
