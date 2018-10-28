package com.nanfriends.english.presenter;

import com.chenchen.collections.http.HttpResult;
import com.nanfriends.english.bean.Question;
import com.nanfriends.english.bean.SProblem;
import com.nanfriends.english.contract.ListContract;
import com.nanfriends.english.model.ListModel;

public class ListPresenter implements ListContract.Presenter {
    private ListContract.Model model;
    private ListContract.View view;

    public ListPresenter(ListContract.View view) {
        this.model = new ListModel();
        this.view = view;
    }

    @Override
    public void getListenOrRead(int tx) {
        model.getListenOrRead(tx, new HttpResult<Question>() {
            @Override
            public void response(Question question) {
                if(question == null){
                    view.tip("数据解析出错");
                }else{
                    view.setData(question);
                }
            }
        });
    }

    @Override
    public void getWriteOrTranslate(int tx) {
        model.getWriteOrTranslate(tx, new HttpResult<SProblem>() {
            @Override
            public void response(SProblem sProblem) {
                if(sProblem == null){
                    view.tip("数据解析出错");
                }else{
                    view.setData(sProblem);
                }
            }
        });
    }
}
