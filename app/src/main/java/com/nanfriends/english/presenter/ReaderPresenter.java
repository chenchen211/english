package com.nanfriends.english.presenter;

import android.os.Environment;
import android.util.Log;

import com.chenchen.collections.http.HttpResult;
import com.chenchen.collections.xframe.utils.log.XLog;
import com.google.gson.Gson;
import com.nanfriends.english.MyApp;
import com.nanfriends.english.bean.Question;
import com.nanfriends.english.bean.Reader;
import com.nanfriends.english.contract.ReaderContract;
import com.nanfriends.english.http.ApiService;
import com.nanfriends.english.http.Download;
import com.nanfriends.english.model.ReaderModel;

import org.xutils.common.util.MD5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import okhttp3.ResponseBody;
import retrofit2.Response;

public class ReaderPresenter implements ReaderContract.Presenter {
    private ReaderContract.Model model;
    private ReaderContract.View view;
    private String filePath;

    public ReaderPresenter(ReaderContract.View view) {
        this.model = new ReaderModel();
        this.view = view;
        filePath = Environment.getExternalStorageDirectory().getAbsolutePath()+"/";
    }

    @Override
    public void download(String url){
        String[] split = url.split("\\.");
        String fileType = split[split.length - 1];
        filePath += MD5.md5(url)+"."+fileType;
        final File file = new File(filePath);
        if(file.exists()){//如果文件存在，直接显示，不存在则从网络下载
            view.setFile(file);
        }else{
            url = ApiService.BASE_URL+url;
            Download instance = Download.getInstance(MyApp.instances.getContext(), url);
            instance.downloadWithFullPath(filePath, new Download.OnDownloadListener() {
                @Override
                public void onStart(long l) {
                    Log.i("reader", "onStart: "+l);
                }

                @Override
                public void onProgress(long l) {
                    Log.i("reader", "onStart: "+l);
                }

                @Override
                public void onFinish(String s) {
                    view.setFile(file);
                }

                @Override
                public void onFailure(String s) {
                    Log.i("reader", "onFailure: "+s);
                }
            });
        }
    }
}
