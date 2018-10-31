package com.nanfriends.english.ui;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chenchen.collections.widget.DividerItemDecoration;
import com.nanfriends.english.R;
import com.nanfriends.english.bean.Option;
import com.nanfriends.english.bean.Problem;
import com.nanfriends.english.bean.SProblem;
import com.nanfriends.english.contract.ProblemContract;
import com.nanfriends.english.presenter.ProblemPresenter;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_problem)
public class ProblemActivity extends BaseActivity implements ProblemContract.View {
    @ViewInject(R.id.rv_problems)
    private RecyclerView rv_problems;

    private ProblemContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("阅读理解");
        leftShow(true);
        rv_problems.setLayoutManager(new LinearLayoutManager(this));
        rv_problems.addItemDecoration(new DividerItemDecoration(this));
        presenter = new ProblemPresenter(this);
        presenter.getProblems(getIntent().getIntExtra("id",0));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter = null;
    }

    @Override
    public void tip(String tip) {
        Toast.makeText(this, tip, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setData(List<SProblem.DataBean> data) {
        rv_problems.setAdapter(new CommonAdapter<SProblem.DataBean>(this, R.layout.item_problem, data) {
            @Override
            protected void convert(final ViewHolder holder, final SProblem.DataBean problem, int position) {
                holder.setText(R.id.problem_title,problem.getQuestion());
                holder.setText(R.id.anwser_a,"A. "+problem.getA());
                holder.setText(R.id.anwser_b,"B. "+problem.getB());
                holder.setText(R.id.anwser_c,"C. "+problem.getC());
                holder.setText(R.id.anwser_d,"D. "+problem.getD());
                holder.setOnClickListener(R.id.answer, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        holder.setText(R.id.answer,"答案："+problem.getAnswer());
                        TextView view = (TextView) holder.getView(R.id.item_jiexi);
                        view.setText("解析："+problem.getJiexi());
                        view.setVisibility(View.VISIBLE);
                    }
                });
            }
        });
    }
}
