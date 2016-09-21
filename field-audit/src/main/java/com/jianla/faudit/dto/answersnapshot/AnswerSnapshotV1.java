package com.jianla.faudit.dto.answersnapshot;

import com.jianla.faudit.dto.AnswerSnapshot;

import java.util.List;

/**
 * 答案快照v1
 *
 * @author : zwj
 * @data : 2016/9/21
 */
public class AnswerSnapshotV1 extends AnswerSnapshot {

    private String title;

    private List<QuestionSnapshot> questions;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<QuestionSnapshot> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionSnapshot> questions) {
        this.questions = questions;
    }

    @Override
    public int getVersion() {
        return 1;
    }


}
