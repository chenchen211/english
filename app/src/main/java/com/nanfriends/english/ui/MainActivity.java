package com.nanfriends.english.ui;

import android.content.Intent;
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
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("题型");
    }

    @Event({R.id.listen,R.id.reader,R.id.translate,R.id.writer})
    private void onClick(View view){
        switch (view.getId()){
            case R.id.listen:
                Intent intent = new Intent();
                changeActivity(intent,false);
                break;
            case R.id.reader:
                break;
            case R.id.translate:
                break;
            case R.id.writer:
                break;
        }
    }
}
