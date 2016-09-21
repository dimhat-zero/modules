package com.jianla.faudit.dao;

import com.jianla.dao.base.BaseDaoI;
import com.jianla.faudit.entity.QnQuestion;

import java.util.List;

/**
 * @author zwj
 * @date 2016/9/21
 */
public interface QnQuestionDao extends BaseDaoI<QnQuestion>{

    /**
     * 删除问卷下的所有问题
     * @param id 问卷id
     */
    void deleteByQnId(Long id);

    /**
     * 找到问卷下的所有问题
     * @param id
     * @return
     */
    List<Long> findQuestionIdsByQnId(Long id);

}
