package com.example.new_jkbd.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.new_jkbd.ExamApplication;
import com.example.new_jkbd.R;
import com.example.new_jkbd.bean.ExamInfo;

/**
 * Created by &&&&& on 2017/7/4.
 */

public class ExamActivity extends AppCompatActivity {
    TextView tvExamInfo;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        initView();
        initData();
    }

    private void initView() {
        tvExamInfo= (TextView) findViewById(R.id.tv_examinfo);
    }

    private void initData() {
        ExamInfo examInfo=ExamApplication.getInstance().getmExamInfo();
        if(examInfo!=null)
        {
            showData(examInfo);
        }
    }

    private void showData(ExamInfo examInfo) {
        tvExamInfo.setText(examInfo.toString());
    }

}
