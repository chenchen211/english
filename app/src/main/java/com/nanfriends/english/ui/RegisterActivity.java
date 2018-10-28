package com.nanfriends.english.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.nanfriends.english.R;
import com.nanfriends.english.contract.RegisterContract;
import com.nanfriends.english.presenter.RegisterPresenter;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.HashMap;
import java.util.Map;

@ContentView(R.layout.activity_register)
public class RegisterActivity extends BaseActivity implements RegisterContract.View {
    @ViewInject(R.id.iv_verify)
    private ImageView imageView;
    @ViewInject(R.id.et_login_username)
    private EditText etUsername;
    @ViewInject(R.id.et_login_name)
    private EditText etName;
    @ViewInject(R.id.et_login_password)
    private EditText etPassword;
    @ViewInject(R.id.et_login_repassword)
    private EditText etRePassword;
    @ViewInject(R.id.et_login_verify)
    private EditText etVerify;


    private RegisterContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("注册");
        presenter = new RegisterPresenter(this);
        presenter.refresh_code();
    }

    @Event({R.id.btn_register,R.id.iv_verify,R.id.btn_go_login})
    private void onClick(View view){
        switch (view.getId()){
            case R.id.btn_register:
                doRegister();
                break;
            case R.id.iv_verify:
                presenter.refresh_code();
                break;
            case R.id.btn_go_login:
                changeActivity(LoginActivity.class,true);
                break;
        }
    }

    private void doRegister() {
        Map<String, String> map = new HashMap<>();
        String username = etUsername.getText().toString();
        String name = etName.getText().toString();
        String password = etPassword.getText().toString();
        String rePassword = etRePassword.getText().toString();
        String code = etVerify.getText().toString();
        if(TextUtils.isEmpty(username)){
            etUsername.setFocusable(true);
            tip("手机号不能为空");
        }else if(TextUtils.isEmpty(name)){
            etName.setFocusable(true);
            tip("姓名不能为空");
        }else if(TextUtils.isEmpty(password)){
            etPassword.setFocusable(true);
            tip("密码不能为空");
        }else if(!password.equals(rePassword)){
            etRePassword.setFocusable(true);
            tip("两次密码不一致");
        }else if(TextUtils.isEmpty(code)){
            etVerify.setFocusable(true);
            tip("验证码不能为空");
        }
        map.put("username", username);
        map.put("pwd", password);
        map.put("truename", name);
        map.put("mobile", username);
        map.put("vcode", code);
        presenter.register(map);
    }

    @Override
    public void success() {
        this.changeActivity(LoginActivity.class,true);
    }

    @Override
    public void tip(String tip) {
        Toast.makeText(this, tip, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void refresh_code(Bitmap bitmap) {
        if(bitmap != null)imageView.setImageBitmap(bitmap);
    }
}
