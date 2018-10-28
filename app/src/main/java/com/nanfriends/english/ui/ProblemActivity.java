package com.nanfriends.english.ui;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chenchen.collections.widget.DividerItemDecoration;
import com.nanfriends.english.R;
import com.nanfriends.english.bean.Option;
import com.nanfriends.english.bean.Problem;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_problem)
public class ProblemActivity extends BaseActivity {
    @ViewInject(R.id.rv_problems)
    private RecyclerView rv_problems;

    private List<Problem> problems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for (int i = 0; i < 10; i++) {
            Problem problem = new Problem();
            problem.setTitle(getString(R.string.problem));
            problem.setAnswer("A");
            Option option = new Option();
            option.setOption_A(getString(R.string.option));
            option.setOption_B(getString(R.string.option));
            option.setOption_C(getString(R.string.option));
            option.setOption_D(getString(R.string.option));
            problem.setOption(option);
            problems.add(problem);
        }

        rv_problems.setLayoutManager(new LinearLayoutManager(this));
        rv_problems.addItemDecoration(new DividerItemDecoration(this));
        rv_problems.setAdapter(new CommonAdapter<Problem>(this, R.layout.item_problem, problems) {
            @Override
            protected void convert(final ViewHolder holder, final Problem problem, int position) {
                holder.setText(R.id.problem_title,problem.getTitle());
                holder.setText(R.id.anwser_a,"A. "+problem.getOption().getOption_A());
                holder.setText(R.id.anwser_b,"B. "+problem.getOption().getOption_B());
                holder.setText(R.id.anwser_c,"C. "+problem.getOption().getOption_C());
                holder.setText(R.id.anwser_d,"D. "+problem.getOption().getOption_D());
                holder.setOnClickListener(R.id.show_answer, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        holder.setText(R.id.show_answer,problem.getAnswer());
                    }
                });
            }
        });
    }
}
