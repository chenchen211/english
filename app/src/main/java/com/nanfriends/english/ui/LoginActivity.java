package com.nanfriends.english.ui;

import android.os.Bundle;
import android.view.View;

import com.nanfriends.english.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;

@ContentView(R.layout.activity_login)
public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Event({R.id.btn_login,R.id.btn_register})
    private void onClick(View view){
        switch (view.getId()){
            case R.id.btn_login:
                changeActivity(MainActivity.class,true);
                break;
            case R.id.btn_register:
                changeActivity(RegisterActivity.class,false);
                break;
        }
    }
}
