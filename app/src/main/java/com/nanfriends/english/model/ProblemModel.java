package com.nanfriends.english.model;

import com.chenchen.collections.http.HttpResult;
import com.chenchen.collections.http.ServiceFactory;
import com.nanfriends.english.MyApp;
import com.nanfriends.english.bean.SProblem;
import com.nanfriends.english.contract.ProblemContract;
import com.nanfriends.english.http.ApiService;

public class ProblemModel implements ProblemContract.Model {
    private ApiService service;

    public ProblemModel() {
        this.service = ServiceFactory.createService(ApiService.class,MyApp.instances.getContext(),ApiService.BASE_URL);
    }

    @Override
    public void getProblems(int id, HttpResult<SProblem> result) {
        service.getProblems(id).enqueue(result);
    }
}
