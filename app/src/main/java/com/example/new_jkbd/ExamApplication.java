package com.example.new_jkbd;

import android.app.Application;
import android.util.Log;

import com.example.new_jkbd.bean.Exam;
import com.example.new_jkbd.bean.ExamInfo;
import com.example.new_jkbd.utils.OkHttpUtils;

import java.util.List;

/**
 * Created by &&&&& on 2017/7/5.
 */

public class ExamApplication extends Application {
    ExamInfo mExamInfo;
    List<Exam> mExamList;
    private static ExamApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
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
                OkHttpUtils<ExamInfo> utils=new OkHttpUtils<>(instance);
                String url="http://101.251.196.90:8080/JztkServer/examInfo";
                utils.url(url)
                        .targetClass(ExamInfo.class)
                        .execute(new OkHttpUtils.OnCompleteListener<ExamInfo>()
                        {

                            @Override
                            public void onSuccess(ExamInfo result) {
                                Log.e("main","result="+result);
                                mExamInfo=result;
                            }

                            @Override
                            public void onError(String error) {
                                Log.e("main","error="+error);
                            }
                        });
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
