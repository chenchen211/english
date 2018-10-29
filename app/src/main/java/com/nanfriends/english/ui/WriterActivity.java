package com.nanfriends.english.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.nanfriends.english.R;
import com.nanfriends.english.bean.SProblem;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.activity_writer)
public class WriterActivity extends BaseActivity {

    @ViewInject(R.id.writer_problem)
    TextView question;
    @ViewInject(R.id.show_answer)
    TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        leftShow(true);
        SProblem.DataBean data = (SProblem.DataBean) getIntent().getSerializableExtra("data");
        if(data != null){
            if(data.getTx() == 3){
                setTitle("翻译");
            }else{
                setTitle("写作");
            }
            question.setText(data.getQuestion());
            answer.setText(data.getAnswer());
        }
    }
}
