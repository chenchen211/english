package com.nanfriends.english.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chenchen.collections.widget.DividerItemDecoration;
import com.nanfriends.english.R;
import com.nanfriends.english.adapter.ProblemAdapter;
import com.nanfriends.english.bean.Problem;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_problem)
public class ProblemActivity extends AppCompatActivity {
    @ViewInject(R.id.rv_problems)
    RecyclerView rv_problems;

    private List<Problem> problems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        problems.add(new Problem());
        rv_problems.setLayoutManager(new LinearLayoutManager(this));
        rv_problems.addItemDecoration(new DividerItemDecoration(this));
        rv_problems.setAdapter(new ProblemAdapter(problems,this));
    }
}
