package com.nanfriends.english.model;

import com.chenchen.collections.http.HttpResult;
import com.chenchen.collections.http.ServiceFactory;
import com.nanfriends.english.MyApp;
import com.nanfriends.english.bean.Question;
import com.nanfriends.english.bean.Reader;
import com.nanfriends.english.bean.SProblem;
import com.nanfriends.english.contract.ListContract;
import com.nanfriends.english.http.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListModel implements ListContract.Model {
    private ApiService service;

    public ListModel() {
        this.service = ServiceFactory.createService(ApiService.class,MyApp.instances.getContext(),ApiService.BASE_URL);
    }

    @Override
    public void getListenOrRead(int tx, HttpResult<Question> result) {
        service.getReaderOrListen(tx).enqueue(result);
    }

    @Override
    public void getWriteOrTranslate(int tx, HttpResult<SProblem> result) {
        service.getProblems(tx).enqueue(result);
    }
}
