package com.jianla.util;

import com.jianla.model.base.Page;

/**
 * @author : zwj
 * @data : 2016/9/23
 */
public class PageUtil {

    public static String addOrderBy(String hql,Page page){
        if (page.getOrder() != null && page.getOrderBy() != null) {
            return new StringBuilder(hql).append(" order by ").append(page.getOrderBy())
                    .append(' ').append(page.getOrder()).toString();
        }
        return hql;
    }
}
