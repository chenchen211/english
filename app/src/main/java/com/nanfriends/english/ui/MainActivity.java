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
        Intent intent = new Intent(this,ListActivity.class);
        switch (view.getId()){
            case R.id.listen:
                intent.putExtra("tx",1);
                changeActivity(intent,false);
                break;
            case R.id.reader:
                intent.putExtra("tx",2);
                break;
            case R.id.translate:
                intent.putExtra("tx",3);
                break;
            case R.id.writer:
                intent.putExtra("tx",4);
                break;
        }
        changeActivity(intent,false);
    }
}
