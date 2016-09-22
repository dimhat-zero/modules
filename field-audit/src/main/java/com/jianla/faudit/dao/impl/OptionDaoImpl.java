package com.jianla.faudit.dao.impl;

import com.jianla.dao.base.impl.BaseDaoImpl;
import com.jianla.faudit.dao.OptionDao;
import com.jianla.faudit.entity.Option;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : zwj
 * @data : 2016/9/21
 */
@Repository
public class OptionDaoImpl extends BaseDaoImpl<Option> implements OptionDao {
    @Override
    public void deleteByQuestionId(Long questionId) {
        String hql="delete from Option where questionId = ?";
        executeHql(hql,new Object[]{questionId});
    }

    @Override
    public List<String> findContentByQuestionId(Long questionId) {
        String hql="select content from Option where questionId = ?";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter(0,questionId);
        return query.list();
    }

    @Override
    public List<Option> findByQuestionId(Long id) {
        String hql="from Option where questionId = ?";
        return find(hql, new Object[]{id});
    }
}
