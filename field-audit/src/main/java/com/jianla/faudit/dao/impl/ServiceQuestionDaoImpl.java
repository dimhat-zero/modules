package com.jianla.faudit.dao.impl;

import com.jianla.dao.base.impl.BaseDaoImpl;
import com.jianla.faudit.dao.ServiceQuestionDao;
import com.jianla.faudit.entity.ServiceQuestion;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : zwj
 * @data : 2016/9/21
 */
@Repository
public class ServiceQuestionDaoImpl extends BaseDaoImpl<ServiceQuestion>  implements ServiceQuestionDao {
    @Override
    public List<Long> findServiceIdByQuestionId(Long questionId) {
        String hql="select serviceId from ServiceQuestion where questionId = ?";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter(0,questionId);
        return query.list();
    }
}
