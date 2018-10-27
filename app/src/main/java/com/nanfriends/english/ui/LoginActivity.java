package com.nanfriends.english.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.nanfriends.english.R;
import com.nanfriends.english.contract.LoginContract;
import com.nanfriends.english.presenter.LoginPresenter;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.HashMap;
import java.util.Map;

@ContentView(R.layout.activity_login)
public class LoginActivity extends BaseActivity implements LoginContract.View {
    @ViewInject(R.id.iv_verify)
    private ImageView imageView;
    @ViewInject(R.id.et_login_username)
    private EditText etUsername;
    @ViewInject(R.id.et_login_password)
    private EditText etPassword;
    @ViewInject(R.id.et_login_verify)
    private EditText etVerify;

    private LoginContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new LoginPresenter(this);
        presenter.refresh_code();
    }
    @Event({R.id.btn_login,R.id.btn_go_register})
    private void onClick(View view){
        switch (view.getId()){
            case R.id.btn_login:
                doLogin();
                break;
            case R.id.btn_go_register:
                changeActivity(RegisterActivity.class,false);
                break;
        }
    }

    private void doLogin() {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();
        String code = etVerify.getText().toString();
        Map<String, String> map = new HashMap<>();
        if(TextUtils.isEmpty(username)){
            etUsername.setFocusable(true);
            tip("手机号不能为空");
        }else if(TextUtils.isEmpty(password)){
            etPassword.setFocusable(true);
            tip("密码不能为空");
        }else if(TextUtils.isEmpty(code)){
            etVerify.setFocusable(true);
            tip("验证码不能为空");
        }
        presenter.login(username,password,code);
    }

    @Override
    public void success() {
        changeActivity(MainActivity.class,true);
    }

    @Override
    public void tip(String tip) {
        Toast.makeText(this, tip, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void refresh_code(Bitmap bitmap) {
        if(bitmap !=null){
            imageView.setImageBitmap(bitmap);
        }
    }
}
