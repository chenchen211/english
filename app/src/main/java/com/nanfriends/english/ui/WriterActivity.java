package com.nanfriends.english.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.nanfriends.english.R;
import com.nanfriends.english.bean.SProblem;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.activity_writer)
public class WriterActivity extends BaseActivity {

    @ViewInject(R.id.writer_problem)
    TextView question;
    @ViewInject(R.id.show_answer)
    TextView answer;
    @ViewInject(R.id.answer)
    TextView show_answer;

    private SProblem.DataBean data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        leftShow(true);
        data = (SProblem.DataBean) getIntent().getSerializableExtra("data");
        if(data != null){
            if(data.getTx() == 3){
                setTitle("翻译");
            }else{
                setTitle("写作");
            }
            question.setText(data.getQuestion());
        }
    }

    @Event({R.id.answer})
    private void onClick(View view){
        switch (view.getId()){
            case R.id.answer:
                show_answer.setVisibility(View.GONE);
                answer.setText(data.getAnswer());
                answer.setVisibility(View.VISIBLE);
                break;
        }
    }
}
