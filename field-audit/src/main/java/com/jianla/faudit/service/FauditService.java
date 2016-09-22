package com.jianla.faudit.service;

import com.jianla.faudit.dto.OptionDto;
import com.jianla.faudit.entity.Faudit;

import java.util.List;

/**
 * @author : zwj
 * @data : 2016/9/21
 */
public interface FauditService {

    /**
     * 用户提交申请单
     * @param userId
     * @return 包含id的对象
     */
    Faudit createFaudit(Long userId);

    /**
     *
     * @param id 验厂id
     * @param qnId 对应问卷id
     * @param options 选择的答案
     */
    void submitAnswer(Long id,Long qnId, List<OptionDto> options);

    void modifyAnswer(Long id,Long qnId,List<OptionDto> options);

}
