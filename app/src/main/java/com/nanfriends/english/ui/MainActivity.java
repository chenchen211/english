package com.nanfriends.english.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.chenchen.collections.utils.SPUtils;
import com.nanfriends.english.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("题型");
    }

    @Event({R.id.listen,R.id.reader,R.id.translate,R.id.writer,R.id.logout})
    private void onClick(View view){
        Intent intent = new Intent(this,ListActivity.class);
        switch (view.getId()){
            case R.id.listen:
                intent.putExtra("tx",1);
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
            case R.id.logout:
                SPUtils.getInstance(this,"english").clear();
                changeActivity(LoginActivity.class,true);
                return;
        }
        changeActivity(intent,false);
    }
}
