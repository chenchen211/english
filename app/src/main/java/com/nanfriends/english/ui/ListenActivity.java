package com.nanfriends.english.ui;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.source.AssetSource;
import com.nanfriends.english.R;

import org.xutils.view.annotation.ContentView;

import java.io.IOException;

@ContentView(R.layout.activity_listen)
public class ListenActivity extends BaseActivity {
    private MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        player = new MediaPlayer();
        try {
            AssetFileDescriptor afd = getAssets().openFd("Faded.mp3");
            player.setDataSource(afd.getFileDescriptor());
            player.prepare();
            player.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
