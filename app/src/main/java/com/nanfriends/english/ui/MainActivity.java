package com.nanfriends.english.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chenchen.collections.widget.DividerItemDecoration;
import com.chenchen.collections.xframe.adapter.decoration.DividerDecoration;
import com.nanfriends.english.R;
import com.nanfriends.english.bean.Type;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    private List<Type> types = new ArrayList<>();
    @ViewInject(R.id.rv_type)
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for (int i = 0; i < 8; i++) {
            Type type = new Type();
            type.setId(i+1);
            type.setTitle("阅读理解");
            types.add(type);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this));
        recyclerView.setAdapter(new CommonAdapter<Type>(this, R.layout.item_type, types) {
            @Override
            protected void convert(ViewHolder holder, Type type, int position) {
                holder.setText(R.id.tv_item_name,type.getTitle());
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        changeActivity(ListenActivity.class,false);
                    }
                });
            }
        });
    }
}
