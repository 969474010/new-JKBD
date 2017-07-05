package com.example.new_jkbd.biz;

import com.example.new_jkbd.dao.ExamDao;
import com.example.new_jkbd.dao.IExamDao;

/**
 * Created by &&&&& on 2017/7/5.
 */

public class ExamBiz implements IExamBiz {
    IExamDao dao;
    public ExamBiz()
    {
        this.dao=new ExamDao();
    }
    @Override
    public void beginExam() {
        dao.loadExamInfo();
        dao.loadQusetion();
    }

    @Override
    public void nextQuestion() {

    }

    @Override
    public void preQuestion() {

    }

    @Override
    public void commitExam() {

    }
}
