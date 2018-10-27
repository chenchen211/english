package com.nanfriends.english.model;

import com.chenchen.collections.http.HttpHelper;
import com.chenchen.collections.http.HttpResult;
import com.nanfriends.english.MyApp;
import com.nanfriends.english.contract.RegisterContract;
import com.nanfriends.english.http.ApiService;

import java.util.Map;

import okhttp3.ResponseBody;

public class RegisterModel implements RegisterContract.Model {

    private ApiService service;

    public RegisterModel() {
        this.service = HttpHelper.getInstance(MyApp.instances.getContext(),ApiService.BASE_URL).getService(ApiService.class);
    }

    @Override
    public void register(Map<String, String> param, HttpResult<ResponseBody> result) {
        service.register(param).enqueue(result);
    }

    @Override
    public void refresh_code(HttpResult<ResponseBody> result) {
        service.getCode().enqueue(result);
    }
}
