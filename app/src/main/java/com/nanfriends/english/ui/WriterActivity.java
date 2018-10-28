package com.nanfriends.english.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nanfriends.english.R;

import org.xutils.view.annotation.ContentView;

@ContentView(R.layout.activity_writer)
public class WriterActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("写作");
        leftShow(true);
    }
}
