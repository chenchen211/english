package com.nanfriends.english.contract;

import com.chenchen.collections.http.HttpResult;
import com.nanfriends.english.bean.Base;
import com.nanfriends.english.bean.Question;
import com.nanfriends.english.bean.Reader;
import com.nanfriends.english.bean.SProblem;

public interface ListContract {
    interface Model {
        void getListenOrRead(int tx, HttpResult<Question> result);
        void getWriteOrTranslate(int tx, HttpResult<SProblem> result);
    }

    interface View {
        void setData(Base data);
        void tip(String tip);
    }

    interface Presenter {
        void getListenOrRead(int tx);
        void getWriteOrTranslate(int tx);
    }
}
