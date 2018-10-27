package com.nanfriends.english.contract;

import android.graphics.Bitmap;

import com.chenchen.collections.http.HttpResult;

import java.util.Map;

import okhttp3.ResponseBody;

public interface RegisterContract {
    
    interface Model {
        void register(Map<String,String> param, HttpResult<ResponseBody> result);
        void refresh_code(HttpResult<ResponseBody> result);
    }

    interface View {
        void success();
        void tip(String tip);
        void refresh_code(Bitmap bitmap);
    }

    interface Presenter {
        void register(Map<String,String> param);
        void refresh_code();
    }
}
