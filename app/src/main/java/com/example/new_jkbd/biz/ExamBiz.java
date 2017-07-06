package com.example.new_jkbd.biz;

import com.example.new_jkbd.ExamApplication;
import com.example.new_jkbd.bean.Exam;
import com.example.new_jkbd.dao.ExamDao;
import com.example.new_jkbd.dao.IExamDao;

import java.util.List;

/**
 * Created by &&&&& on 2017/7/5.
 */

public class ExamBiz implements IExamBiz {
    IExamDao dao;
    int ExamIndex=0;
    List<Exam> examList=null;
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
    public Exam getExam() {
        examList=ExamApplication.getInstance().getmExamList();
        if(examList!=null) {
            return examList.get(ExamIndex);
        }else
        {
            return null;
        }
    }

    @Override
    public Exam nextQuestion() {
        if(examList!=null && ExamIndex<examList.size()-1)
        {
            ExamIndex++;
            return examList.get(ExamIndex);
        }else
        {
            return null;
        }
    }

    @Override
    public Exam preQuestion() {
        if(examList!=null && ExamIndex>0)
        {
            ExamIndex--;
            return examList.get(ExamIndex);
        }else
        {
            return null;
        }
    }

    @Override
    public void commitExam() {

    }

    @Override
    public String getExamIndex() {
        return (ExamIndex+1)+".";
    }
}
