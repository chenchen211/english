package com.nanfriends.english.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chenchen.collections.xframe.adapter.BaseRecyclerViewAdapter;
import com.chenchen.collections.xframe.adapter.XViewHolder;
import com.nanfriends.english.R;
import com.nanfriends.english.bean.Problem;

import java.util.List;

public class ProblemAdapter extends BaseRecyclerViewAdapter<Problem,RecyclerView.ViewHolder> {

    private List<Problem> problems;
    private Context context;

    public ProblemAdapter(List<Problem> problems, Context context) {
        this.problems = problems;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_problem,viewGroup,false);
        return new ProblemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return problems.size();
    }

    public class ProblemViewHolder extends RecyclerView.ViewHolder {

        public ProblemViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
