package com.jianla.faudit.service;

import com.jianla.faudit.dto.OptionDto;
import com.jianla.faudit.dto.QuestionaireDto;
import com.jianla.faudit.entity.Answer;

import java.util.List;

/**
 * @author : zwj
 * @data : 2016/9/21
 */
public interface AnswerService {

    /**
     * 提交问卷回答
     * 理论上提交的是文件id，和答案，后台进行校验
     *
     * @param qnId 问卷id（非强制外键）
     * @param options 所选选项
     */
    Answer submitAnswer(Long qnId, List<OptionDto> options);

    /**
     * 提交问卷答案
     * @param qnId
     * @param options
     * @param version 版本号，即更新时间
     */
    Answer submitAnswer(Long qnId, List<OptionDto> options,long version);

    /**
     * 修改问卷回答
     */
    void modifyAnswer(Long id, List<OptionDto> options);

    /**
     * 查看问卷回答
     * @param id
     * @return
     */
    QuestionaireDto getAnswerById(Long id);

}
