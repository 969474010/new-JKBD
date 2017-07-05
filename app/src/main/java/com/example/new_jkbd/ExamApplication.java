package com.example.new_jkbd;

import android.app.Application;
import android.util.Log;

import com.example.new_jkbd.bean.Exam;
import com.example.new_jkbd.bean.ExamInfo;
import com.example.new_jkbd.bean.Result;
import com.example.new_jkbd.biz.ExamBiz;
import com.example.new_jkbd.biz.IExamBiz;
import com.example.new_jkbd.utils.OkHttpUtils;
import com.example.new_jkbd.utils.ResultUtils;

import java.util.List;

/**
 * Created by &&&&& on 2017/7/5.
 */

public class ExamApplication extends Application {
    ExamInfo mExamInfo;
    List<Exam> mExamList;
    private static ExamApplication instance;
    IExamBiz biz;
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        biz=new ExamBiz();
        initData();
    }

    public static ExamApplication getInstance()
    {
        return instance;
    }
    private void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
               biz.beginExam();
            }
        }).start();
    }

    public ExamInfo getmExamInfo() {
        return mExamInfo;
    }

    public void setmExamInfo(ExamInfo mExamInfo) {
        this.mExamInfo = mExamInfo;
    }

    public List<Exam> getmExamList() {
        return mExamList;
    }

    public void setmExamList(List<Exam> mExamList) {
        this.mExamList = mExamList;
    }
}
