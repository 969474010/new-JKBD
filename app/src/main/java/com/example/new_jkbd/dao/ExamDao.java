package com.example.new_jkbd.dao;

import android.util.Log;

import com.example.new_jkbd.ExamApplication;
import com.example.new_jkbd.bean.Exam;
import com.example.new_jkbd.bean.ExamInfo;
import com.example.new_jkbd.bean.Result;
import com.example.new_jkbd.utils.OkHttpUtils;
import com.example.new_jkbd.utils.ResultUtils;

import java.util.List;

/**
 * Created by &&&&& on 2017/7/5.
 */

public class ExamDao implements IExamDao {
    @Override
    public void loadExamInfo() {
        OkHttpUtils<ExamInfo> utils=new OkHttpUtils<>(ExamApplication.getInstance());
        String url="http://101.251.196.90:8080/JztkServer/examInfo";
        utils.url(url)
                .targetClass(ExamInfo.class)
                .execute(new OkHttpUtils.OnCompleteListener<ExamInfo>()
                {

                    @Override
                    public void onSuccess(ExamInfo result) {
                        Log.e("main","result="+result);
                        ExamApplication.getInstance().setmExamInfo(result);

                    }

                    @Override
                    public void onError(String error) {
                        Log.e("main","error="+error);
                    }
                });
    }

    @Override
    public void loadQusetion() {
        OkHttpUtils<String> utils1=new OkHttpUtils<>(ExamApplication.getInstance());
        String url1="http://101.251.196.90:8080/JztkServer/getQuestions?testType=rand";
        utils1.url(url1)
                .targetClass(String.class)
                .execute(new OkHttpUtils.OnCompleteListener<String>()
                {

                    @Override
                    public void onSuccess(String jsonStr) {
                        Result result= ResultUtils.getListResultFromJson(jsonStr);
                        if(result!=null&&result.getError_code()==0)
                        {
                            List<Exam> list = result.getResult();
                            if(list!=null&&list.size()>0)
                            {
                                ExamApplication.getInstance().setmExamList(list);

                            }
                        }
                    }

                    @Override
                    public void onError(String error) {
                        Log.e("mian","error="+error);
                    }
                });
    }
}
