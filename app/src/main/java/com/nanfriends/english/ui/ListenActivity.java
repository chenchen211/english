package com.nanfriends.english.ui;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.github.barteksc.pdfviewer.source.AssetSource;
import com.nanfriends.english.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;

import java.io.IOException;

@ContentView(R.layout.activity_listen)
public class ListenActivity extends BaseActivity {
    private MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("听力");
        player = new MediaPlayer();
        try {
            AssetFileDescriptor afd = getAssets().openFd("Faded.mp3");
            player.setDataSource(afd.getFileDescriptor());
            player.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Event({R.id.iv_audio})
    private void onClick(View view){
        switch (view.getId()){
            case R.id.iv_audio:
                if(player.isPlaying()){
                    player.pause();
                }else{
                    player.start();
                }
                break;
        }
    }
}
