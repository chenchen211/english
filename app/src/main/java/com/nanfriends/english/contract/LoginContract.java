package com.nanfriends.english.contract;

import android.app.Activity;
import android.graphics.Bitmap;

import com.chenchen.collections.http.HttpResult;

import okhttp3.ResponseBody;

public interface LoginContract {
    interface Model {
        void login(String username, String password, String code, HttpResult<ResponseBody> result);
        void refresh_code(HttpResult<ResponseBody> result);
    }

    interface View {
        void changeActivity(Class<?> clz);
        void tip(String tip);
        void refresh_code(Bitmap bitmap);
    }

    interface Presenter {
        void login(String username, String password, String code);
        void refresh_code();
    }
}
