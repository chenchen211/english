package com.nanfriends.english.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chenchen.collections.utils.SPUtils;
import com.nanfriends.english.MyApp;
import com.nanfriends.english.R;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class BaseActivity extends AppCompatActivity {
    @ViewInject(R.id.tv_title)
    TextView textView;
    @ViewInject(R.id.iv_title_left)
    ImageView ivLeft;
    @ViewInject(R.id.iv_title_right)
    ImageView ivRight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
    }
    public void changeActivity(Class<?> activity, boolean isFinish){
        Intent intent = new Intent(this,activity);
        startActivity(intent);
        if(isFinish){
            finish();
        }
    }
    protected void setTitle(String title){
        if(textView != null){textView.setText(title);}
    }
    protected void leftShow(boolean isShow){
        if(!isShow){
            ivLeft.setVisibility(View.GONE);
        }else{
            ivLeft.setVisibility(View.VISIBLE);
        }
    }
    protected void rightShow(boolean isShow){
        if(isShow){
            ivRight.setVisibility(View.GONE);
        }else{
            ivRight.setVisibility(View.VISIBLE);
        }
    }
    protected void showIcon(){
        ivLeft.setVisibility(View.VISIBLE);
        ivRight.setVisibility(View.VISIBLE);
    }
    @Event({R.id.iv_title_left})
    private void onClick(View view){
        switch (view.getId()){
            case R.id.iv_title_left:
                finish();
                break;
        }
    }
    public void changeActivity(Intent intent, boolean isFinish){
        startActivity(intent);
        if(isFinish){
            finish();
        }
    }
    public void saveToken(String token){
        MyApp.instances.setToken(token);
    }
    public String getToken(){
        return MyApp.instances.getToken();
    }
    public SPUtils getSP(){
        return MyApp.instances.getSP();
    }
}
