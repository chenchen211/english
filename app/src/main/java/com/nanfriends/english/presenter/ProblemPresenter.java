package com.nanfriends.english.presenter;

import com.chenchen.collections.http.HttpResult;
import com.nanfriends.english.bean.SProblem;
import com.nanfriends.english.contract.ProblemContract;
import com.nanfriends.english.model.ProblemModel;

import java.util.List;

public class ProblemPresenter implements ProblemContract.Presenter {
    private ProblemContract.View view;
    private ProblemContract.Model model;

    public ProblemPresenter(ProblemContract.View view) {
        model = new ProblemModel();
        this.view = view;
    }

    @Override
    public void getProblems(int id) {
        model.getProblems(id, new HttpResult<SProblem>() {
            @Override
            public void response(SProblem sProblem) {
                if(sProblem != null){
                    List<SProblem.DataBean> dataX = sProblem.getDataX();
                    if(dataX!=null && !dataX.isEmpty()){
                        view.setData(dataX);
                    }else{
                        view.tip("暂无相关试题");
                    }
                }else{
                    view.tip("数据解析出错");
                }
            }
        });
    }
}
