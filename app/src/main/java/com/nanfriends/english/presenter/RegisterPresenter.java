package com.nanfriends.english.presenter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.chenchen.collections.http.HttpResult;
import com.google.gson.Gson;
import com.nanfriends.english.bean.Base;
import com.nanfriends.english.contract.RegisterContract;
import com.nanfriends.english.model.RegisterModel;
import com.nanfriends.english.ui.LoginActivity;

import java.io.IOException;
import java.util.Map;

import okhttp3.ResponseBody;

public class RegisterPresenter implements RegisterContract.Presenter {
    private RegisterContract.Model model;
    private RegisterContract.View view;

    public RegisterPresenter(RegisterContract.View view) {
        this.model = new RegisterModel();
        this.view = view;
    }

    @Override
    public void register(Map<String, String> param) {
        if(param == null || param.isEmpty()) view.tip("参数不能为空");
        model.register(param, new HttpResult<ResponseBody>() {
            @Override
            public void response(ResponseBody responseBody) {
                try {
                    Base base = new Gson().fromJson(responseBody.string(),Base.class);
                    if(base.getCode()==1){
                        view.success();
                    }else{
                        view.tip(base.getMsg());
                    }
                } catch (IOException e) {
                    view.tip("响应数据出错");
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
