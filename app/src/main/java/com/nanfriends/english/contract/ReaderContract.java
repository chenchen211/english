package com.nanfriends.english.contract;

import com.chenchen.collections.http.HttpResult;
import com.nanfriends.english.bean.Reader;

import java.io.File;

import okhttp3.ResponseBody;

public interface ReaderContract {
    interface Model {
        void getData(int id, HttpResult<ResponseBody> result);
    }

    interface View {
        void setFile(File file);
        void tip(String tip);
    }

    interface Presenter {
        void getData(int id);
    }
}
