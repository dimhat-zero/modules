package com.jianla.faudit.dao.impl;

import com.jianla.dao.base.impl.BaseDaoImpl;
import com.jianla.faudit.dao.QnQuestionDao;
import com.jianla.faudit.entity.QnQuestion;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zwj
 * @date 2016/9/21
 */
@Repository
public class QnQuestionDaoImpl extends BaseDaoImpl<QnQuestion> implements QnQuestionDao {
    @Override
    public void deleteByQnId(Long id) {
        String hql="delete from QnQuestion where qnId =?";
        executeHql(hql, new Object[]{id});
    }

    @Override
    public List<Long> findQuestionIdsByQnId(Long id) {
        String hql="select questionId from QnQuestion where qnId = ?";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter(0,id);
        return query.list();
    }
}
