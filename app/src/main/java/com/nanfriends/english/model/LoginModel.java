package com.nanfriends.english.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.chenchen.collections.http.HttpResult;
import com.chenchen.collections.http.ServiceFactory;
import com.google.gson.Gson;
import com.nanfriends.english.MyApp;
import com.nanfriends.english.bean.User;
import com.nanfriends.english.contract.LoginContract;
import com.nanfriends.english.http.ApiService;
import com.nanfriends.english.presenter.LoginPresenter;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginModel implements LoginContract.Model {
    private ApiService service;

    public LoginModel(LoginPresenter presenter) {
        service = ServiceFactory.createService(ApiService.class,MyApp.instances.getContext(),ApiService.BASE_URL);
    }

    @Override
    public void login(String username, String password, String code, HttpResult<ResponseBody> result) {
        service.login(username,password,code).enqueue(result);
    }

    @Override
    public void refresh_code(HttpResult<ResponseBody> result) {
        service.getCode().enqueue(result);
    }
}
