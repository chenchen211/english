package com.nanfriends.english.contract;

import com.chenchen.collections.http.HttpResult;
import com.nanfriends.english.bean.Problem;
import com.nanfriends.english.bean.SProblem;

import java.util.List;

public interface ProblemContract {
    interface Model {
        void getProblems(int id, HttpResult<SProblem> result);
    }

    interface View {
        void tip(String tip);
        void setData(List<SProblem.DataBean> data);
    }

    interface Presenter {
        void getProblems(int id);
    }
}
