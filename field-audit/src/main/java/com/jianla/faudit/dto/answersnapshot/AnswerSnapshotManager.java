package com.jianla.faudit.dto.answersnapshot;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jianla.faudit.dto.AnswerSnapshot;
import com.jianla.faudit.exception.FauditException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 答案快照管理器
 *
 * @author : zwj
 * @data : 2016/9/21
 */
public class AnswerSnapshotManager {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final Map<Integer,AnswerSnapshot> answerSnapshotMap;

    public AnswerSnapshotManager(List<AnswerSnapshot> answerSnapshots) {
        this.answerSnapshotMap  = new HashMap<>();
        for (AnswerSnapshot answerSnapshot : answerSnapshots) {
            answerSnapshotMap.put(answerSnapshot.getVersion(),answerSnapshot);
        }
    }

    public AnswerSnapshot restore(String str){
        JSONObject jsonObject = JSON.parseObject(str);
        Integer version = (Integer) jsonObject.get("version");
        if(version==null){
            logger.error("can't restore str,getVersion not find. str = {}",str);
            throw new FauditException("can't restore str,getVersion not find. str = "+str);
        }
        AnswerSnapshot answerSnapshot = answerSnapshotMap.get(version);
        if(answerSnapshot==null){
            logger.error("can't restore str,restorer not find. str = {}",str);
            throw new FauditException("can't restore str,restorer not find. str = "+str);
        }
        return answerSnapshot.restore(str);
    }
}
