package com.nanfriends.english.contract;

import com.chenchen.collections.http.HttpResult;
import com.nanfriends.english.bean.Question;
import com.nanfriends.english.bean.Reader;

import java.io.File;

import okhttp3.ResponseBody;

public interface ReaderContract {
    interface Model {
        void download(String path,HttpResult<ResponseBody> result);
    }

    interface View {
        void setFile(File file);
        void tip(String tip);
    }

    interface Presenter {
        void download(String path);
    }
}
