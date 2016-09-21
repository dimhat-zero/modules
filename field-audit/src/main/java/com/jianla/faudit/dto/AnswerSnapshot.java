package com.jianla.faudit.dto;

import com.alibaba.fastjson.JSON;

/**
 * 答案快照接口
 *
 * json字符串 如何 还原成对象？
 * 根据版本号
 *
 * @author : zwj
 * @data : 2016/9/21
 */
public abstract class AnswerSnapshot {

    /**
     * 版本号
     */
    public abstract int getVersion();

    /**
     * 恢复成answerSnapshot对象
     * @param str
     * @return
     */
    public AnswerSnapshot restore(String str) {
        return JSON.parseObject(str, this.getClass());
    }

    public String snapshot() {
        return JSON.toJSONString(this);
    }

}
