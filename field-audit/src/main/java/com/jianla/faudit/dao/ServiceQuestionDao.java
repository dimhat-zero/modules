package com.jianla.faudit.dao;

import com.jianla.dao.base.BaseDaoI;
import com.jianla.faudit.entity.ServiceQuestion;

import java.util.List;

/**
 * 服务-问卷 dao
 *
 * @author : zwj
 * @data : 2016/9/21
 */
public interface ServiceQuestionDao extends BaseDaoI<ServiceQuestion> {
    List<Long> findServiceIdByQuestionId(Long id);
}
