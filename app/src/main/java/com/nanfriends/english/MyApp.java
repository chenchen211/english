package com.nanfriends.english;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.chenchen.collections.utils.SPUtils;

import org.xutils.image.ImageOptions;
import org.xutils.x;

public class MyApp extends Application {
    private SQLiteDatabase db;
    public static MyApp instances;

    private Context context;
    private ImageOptions options;
    private String token;
    private final String SP_NAME ="farmshop";
    private SPUtils sp;

    @Override
    public void onCreate() {
        super.onCreate();
        instances =this;
        context=getApplicationContext();
        sp = SPUtils.getInstance(context,SP_NAME);

        //初始化xutils
        x.Ext.init(this);
        x.Ext.setDebug(false);
        options = new ImageOptions.Builder()
                .setLoadingDrawableId(R.mipmap.loading)
                .setFailureDrawableId(R.mipmap.loading)
                .build();
    }


    public Context getContext() {
        return context;
    }


    public ImageOptions getOptions() {
        return options;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        instances.token = token;
    }

    public SPUtils getSP() {
        return sp;
    }
}
