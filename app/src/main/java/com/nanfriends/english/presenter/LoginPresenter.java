package com.nanfriends.english.presenter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.chenchen.collections.http.HttpResult;
import com.google.gson.Gson;
import com.nanfriends.english.bean.User;
import com.nanfriends.english.contract.LoginContract;
import com.nanfriends.english.model.LoginModel;
import com.nanfriends.english.ui.MainActivity;

import java.io.IOException;

import okhttp3.ResponseBody;

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.Model model;
    private LoginContract.View view;

    public LoginPresenter(LoginContract.View view) {
        this.model = new LoginModel(this);
        this.view = view;
    }

    @Override
    public void login(String username, String password, String code) {
        model.login(username, password, code, new HttpResult<ResponseBody>() {
            @Override
            public void response(ResponseBody responseBody) {
                Gson gson = new Gson();
                try {
                    User user = gson.fromJson(responseBody.string(),User.class);
                    if(user != null){
                        if(user.getCode() == 1){
                            view.changeActivity(MainActivity.class);
                        }else{
                            view.tip(user.getMsg());
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void refresh_code() {
        model.refresh_code(new HttpResult<ResponseBody>() {
            @Override
            public void response(ResponseBody responseBody) {
                try {
                    byte[] bytes = responseBody.bytes();
                    Bitmap bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                    view.refresh_code(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
