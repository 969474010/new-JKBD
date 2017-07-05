package com.example.new_jkbd;

import android.app.Application;
import android.util.Log;

import com.example.new_jkbd.bean.Exam;
import com.example.new_jkbd.bean.ExamInfo;
import com.example.new_jkbd.bean.Result;
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

                OkHttpUtils<String> utils1=new OkHttpUtils<>(instance);
                String url1="http://101.251.196.90:8080/JztkServer/getQuestions?testType=rand";
                utils1.url(url1)
                        .targetClass(String.class)
                        .execute(new OkHttpUtils.OnCompleteListener<String>()
                        {

                            @Override
                            public void onSuccess(String jsonStr) {
                                Result result=ResultUtils.getListResultFromJson(jsonStr);
                                if(result!=null&&result.getError_code()==0)
                                {
                                    List<Exam> list = result.getResult();
                                    if(list!=null&&list.size()>0)
                                    {
                                        mExamList=list;
                                    }
                                }
                            }

                            @Override
                            public void onError(String error) {
                                Log.e("mian","error="+error);
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
