package com.jianla.faudit.service;

/**
 * @author : zwj
 * @data : 2016/9/21
 */
public interface AnswerService {

    /**
     * 提交问卷回答
     * 理论上提交的是文件id，和答案，后台进行校验
     *
     * @param fauditId
     * @param questionAnswers 所选选项
     */
   // Answer submitAnswer(Long fauditId, List<QuestionAnswer> questionAnswers);

    /**
     * 提交问卷答案
     * @param qnId
     * @param options
     * @param version 版本号，即更新时间
     */
    //Answer submitAnswer(Long qnId, List<OptionDto> options,long version);

    /**
     * 修改问卷回答
     */
    //void modifyAnswer(Long id, List<OptionDto> options);

    /**
     * 查看问卷回答
     * @param id
     * @return
     */
   // QuestionnaireDto getAnswerById(Long id);

}
