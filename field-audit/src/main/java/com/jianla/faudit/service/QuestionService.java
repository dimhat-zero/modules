package com.jianla.faudit.service;

import com.jianla.faudit.dto.QuestionDto;
import com.jianla.faudit.entity.Question;

import java.util.List;

/**
 * 问题服务
 *
 * @author : zwj
 * @data : 2016/9/21
 */
public interface QuestionService {

    /**
     * 创建一个问题
     * @param content 问题内容
     * @param type 问题类型
     * @param options 问题选项（空字符串表示用户自定义填写）
     */
    void create(Long qnId,String content,Short type,List<String> options);

    /**
     * 修改一个问题
     * @param id 问题id
     * @param content 问题内容
     * @param type 问题类型
     * @param options 问题选项（空字符串表示用户自定义填写）
     */
    void update(Long id,String content,Short type,List<String> options);

    /**
     * 删除一个问题
     * @param id 问题id
     */
    void delete(Long id);

    void delete(Question question);

    Question getById(Long id);

    QuestionDto getDetailById(Long id);

    List<Question> findByOrgId(Long orgId);

    List<QuestionDto> findDetailByIds(List<Long> questionIds);

    void deleteByQnId(Long qnId);

    List<Long> findIdsByQnId(Long qnId);

    List<QuestionDto> findByQnId(Long id);
}
