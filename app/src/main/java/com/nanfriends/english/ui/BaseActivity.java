package com.nanfriends.english.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.chenchen.collections.utils.SPUtils;
import com.nanfriends.english.MyApp;
import com.nanfriends.english.R;

import org.xutils.view.annotation.Event;
import org.xutils.x;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
    }
    protected void changeActivity(Class<?> activity){
        Intent intent = new Intent(this,activity);
        startActivity(intent);
    }
    protected void changeActivity(Class<?> activity, boolean isFinish){
        Intent intent = new Intent(this,activity);
        startActivity(intent);
        if(isFinish){
            finish();
        }
    }
    @Event({R.id.iv_title_left})
    private void onClick(View view){
        switch (view.getId()){
            case R.id.iv_title_left:
                finish();
                break;
        }
    }
    protected void changeActivity(Intent intent, boolean isFinish){
        startActivity(intent);
        if(isFinish){
            finish();
        }
    }
    protected void saveToken(String token){
        MyApp.instances.setToken(token);
    }
    protected String getToken(){
        return MyApp.instances.getToken();
    }
    protected SPUtils getSP(){
        return MyApp.instances.getSP();
    }
}
