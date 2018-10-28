package com.nanfriends.english.model;

import com.chenchen.collections.http.HttpHelper;
import com.chenchen.collections.http.HttpResult;
import com.chenchen.collections.http.ServiceFactory;
import com.chenchen.collections.utils.Download;
import com.nanfriends.english.MyApp;
import com.nanfriends.english.bean.Question;
import com.nanfriends.english.contract.ReaderContract;
import com.nanfriends.english.http.ApiService;

import java.io.File;

import okhttp3.ResponseBody;

public class ReaderModel implements ReaderContract.Model {
    private ApiService service;

    public ReaderModel() {
        this.service = HttpHelper.getInstance(MyApp.instances.getContext(),ApiService.BASE_URL).getService(ApiService.class);
    }

    @Override
    public void getData(int id, HttpResult<Question> result) {
        service.getReaderOrListen(id).enqueue(result);
    }
}
