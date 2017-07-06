package com.example.new_jkbd.biz;

import com.example.new_jkbd.bean.Exam;

/**
 * Created by &&&&& on 2017/7/5.
 */

public interface IExamBiz {
    void beginExam();
    Exam getExam();
    Exam nextQuestion();
    Exam preQuestion();
    void commitExam();
    String getExamIndex();
}
