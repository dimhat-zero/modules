package com.jianla.faudit.util;

import com.jianla.faudit.exception.FauditException;

/**
 * @author : zwj
 * @data : 2016/9/23
 */
public class AuthUtil {

    public static void assertEqual(Long a,Long b){
        if(a==null || b==null || !a.equals(b))
            throw new FauditException("no operation permission");
    }
}
