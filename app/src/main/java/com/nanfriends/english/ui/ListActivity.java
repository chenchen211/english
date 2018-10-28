package com.nanfriends.english.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chenchen.collections.widget.DividerItemDecoration;
import com.nanfriends.english.R;
import com.nanfriends.english.bean.Base;
import com.nanfriends.english.bean.Question;
import com.nanfriends.english.bean.SProblem;
import com.nanfriends.english.contract.ListContract;
import com.nanfriends.english.presenter.ListPresenter;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_list)
public class ListActivity extends BaseActivity implements ListContract.View {

    private int tx=1;
    @ViewInject(R.id.rv_list)
    RecyclerView recyclerView;
    private ListContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ListPresenter(this);
        Intent intent = getIntent();
        if(intent!=null){
            tx = intent.getIntExtra("tx",1);
        }
        switch (tx){
            case 1:
                setTitle("听力练习");
                presenter.getListenOrRead(tx);
                break;
            case 2:
                setTitle("阅读理解");
                presenter.getListenOrRead(tx);
                break;
            case 3:
                setTitle("翻译练习");
                presenter.getWriteOrTranslate(tx);
                break;
            case 4:
                setTitle("写作练习");
                presenter.getWriteOrTranslate(tx);
                break;
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this));
    }

    @Override
    public void setData(final Base data) {
        if(data instanceof Question){
            Question question = ((Question) data);
            List<Question.DataBean> qlist = question.getDataX();
            recyclerView.setAdapter(new CommonAdapter<Question.DataBean>(this,R.layout.item_type,qlist) {
                @Override
                protected void convert(ViewHolder holder, final Question.DataBean dataBean, int position) {
                    holder.setText(R.id.tv_item_name,dataBean.getTitle());
                    String level = dataBean.getLevel() == 1 ? "四级" : "六级";
                    holder.setText(R.id.tv_item_type,level);
                    holder.setVisible(R.id.tv_item_type,true);
                    holder.itemView.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            Intent intent;
                            if(dataBean.getTx()==1){//listen
                                intent = new Intent(ListActivity.this,ListenActivity.class);
                            }else{
                                intent = new Intent(ListActivity.this,ReaderActivity.class);
                            }
                            intent.putExtra("data",dataBean);
                            changeActivity(intent,false);
                        }
                    });
                }
            });
        }else if(data instanceof SProblem){
            SProblem sProblem = (SProblem) data;
            List<SProblem.DataBean> plist = sProblem.getDataX();
            recyclerView.setAdapter(new CommonAdapter<SProblem.DataBean>(this,R.layout.item_type,plist) {

                @Override
                protected void convert(ViewHolder holder, final SProblem.DataBean dataBean, int position) {
                    holder.setText(R.id.tv_item_name,dataBean.getQuestion());
                    String level = dataBean.getLevel() == 1 ? "四级" : "六级";
                    holder.setText(R.id.tv_item_type,level);
                    holder.setVisible(R.id.tv_item_type,true);
                    holder.itemView.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ListActivity.this,WriterActivity.class);
                            intent.putExtra("data",dataBean);
                            changeActivity(intent,false);
                        }
                    });
                }
            });
        }

    }

    @Override
    public void tip(String tip) {
        Toast.makeText(this, tip, Toast.LENGTH_SHORT).show();
    }
}
