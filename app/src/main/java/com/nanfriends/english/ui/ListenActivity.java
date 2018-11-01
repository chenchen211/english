package com.nanfriends.english.ui;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.chenchen.collections.widget.DividerItemDecoration;
import com.nanfriends.english.ProblemAdapter;
import com.nanfriends.english.R;
import com.nanfriends.english.bean.Question;
import com.nanfriends.english.bean.SProblem;
import com.nanfriends.english.contract.ProblemContract;
import com.nanfriends.english.contract.ReaderContract;
import com.nanfriends.english.presenter.ProblemPresenter;
import com.nanfriends.english.presenter.ReaderPresenter;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.io.File;
import java.io.IOException;
import java.util.List;

@ContentView(R.layout.activity_listen)
public class ListenActivity extends BaseActivity implements ReaderContract.View,ProblemContract.View {
    private static final int REQUEST_CODE = 206;
    private MediaPlayer player;
    @ViewInject(R.id.iv_audio)
    ImageView ivPlayer;
    @ViewInject(R.id.listen)
    RecyclerView recyclerView;
    private ReaderPresenter presenter;
    private Question.DataBean data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("听力");
        leftShow(true);
        player = new MediaPlayer();
        Intent intent = getIntent();
        data = (Question.DataBean) intent.getSerializableExtra("data");
        if(data!=null){
            presenter = new ReaderPresenter(this);
            if(ActivityCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},REQUEST_CODE);
            }else{
                presenter.download(data.getPath());
            }
            ProblemPresenter problemPresenter = new ProblemPresenter(this);
            problemPresenter.getProblems(data.getId());
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this));
    }

    @Event({R.id.iv_audio})
    private void onClick(View view){
        switch (view.getId()){
            case R.id.iv_audio:
                if(player.isPlaying()){
                    player.pause();
                    ivPlayer.setImageResource(R.mipmap.icon_pause);
                }else{
                    player.start();
                    ivPlayer.setImageResource(R.mipmap.icon_play);
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.reset();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == REQUEST_CODE){
            presenter.download(data.getPath());
        }else{
            tip("权限获取失败");
        }
    }

    @Override
    public void setFile(File file) {
        try {
            player.setDataSource(file.getAbsolutePath());
            player.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void tip(String tip) {
        Toast.makeText(this, tip, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setData(List<SProblem.DataBean> data) {
        if(data != null){
            recyclerView.setAdapter(new ProblemAdapter(this,R.layout.item_problem_vertical,data));
        }
    }
}
