package com.example.new_jkbd.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.new_jkbd.ExamApplication;
import com.example.new_jkbd.R;
import com.example.new_jkbd.bean.Exam;
import com.example.new_jkbd.bean.ExamInfo;

import java.util.List;

/**
 * Created by &&&&& on 2017/7/4.
 */

public class ExamActivity extends AppCompatActivity {
    TextView tvExamInfo,tvExamTitle,tv_op1,tv_op2,tv_op3,tv_op4;
    ImageView imageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        initView();
        initData();
    }

    private void initView() {

        tvExamInfo= (TextView) findViewById(R.id.tv_examinfo);
        tvExamTitle= (TextView) findViewById(R.id.tv_exam_title);
        tv_op1= (TextView) findViewById(R.id.tv_op1);
        tv_op2= (TextView) findViewById(R.id.tv_op2);
        tv_op3= (TextView) findViewById(R.id.tv_op3);
        tv_op4= (TextView) findViewById(R.id.tv_op4);
        imageView= (ImageView) findViewById(R.id.im_exam_image);
    }

    private void initData() {
        ExamInfo examInfo=ExamApplication.getInstance().getmExamInfo();
        if(examInfo!=null)
        {
            showData(examInfo);
        }
        List<Exam> examList=ExamApplication.getInstance().getmExamList();
        if(examList!=null)
        {
            showExam(examList);
        }
    }

    private void showExam(List<Exam> examList) {
        Exam exam=examList.get(0);
        if(exam!=null)
        {
            tvExamTitle.setText(exam.getQuestion());
            tv_op1.setText(exam.getItem1());
            tv_op2.setText(exam.getItem2());
            tv_op3.setText(exam.getItem3());
            tv_op4.setText(exam.getItem4());
        }
    }

    private void showData(ExamInfo examInfo) {
        tvExamInfo.setText(examInfo.toString());
    }

}
