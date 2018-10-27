package com.nanfriends.english.presenter;

import android.os.Environment;

import com.chenchen.collections.http.HttpResult;
import com.chenchen.collections.utils.Download;
import com.google.gson.Gson;
import com.nanfriends.english.MyApp;
import com.nanfriends.english.bean.Reader;
import com.nanfriends.english.contract.ReaderContract;
import com.nanfriends.english.http.ApiService;
import com.nanfriends.english.model.ReaderModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.ResponseBody;
import retrofit2.Response;

public class ReaderPresenter implements ReaderContract.Presenter {
    private ReaderContract.Model model;
    private ReaderContract.View view;
    private String filePath;
    private String fileType;
    private File file;

    public ReaderPresenter(ReaderContract.View view) {
        this.model = new ReaderModel();
        this.view = view;
        filePath = Environment.getExternalStorageDirectory().getAbsolutePath()+"/";
    }

    @Override
    public void getData(int id) {
        model.getData(id, new HttpResult<ResponseBody>() {
            @Override
            public void response(ResponseBody responseBody) {
                if(responseBody != null){
                    try {
                        Reader reader = new Gson().fromJson(responseBody.string(),Reader.class);
                        String url = ApiService.BASE_URL;
                        String path = reader.getPath();
                        String[] split = path.split("//.");
                        fileType = split[split.length-1];
                        filePath += System.currentTimeMillis()+"."+fileType;
                        download(url);
                    } catch (IOException e) {
                        view.tip(e.getMessage());
                    }
                }
            }
        });
    }
    private void download(String url){
        Download instance = Download.getInstance(MyApp.instances.getContext(), url);
        instance.downloadWithFullPath(filePath, new Download.OnDownloadListener() {
            @Override
            public void onStart(long l) {

            }

            @Override
            public void onProgress(long l) {

            }

            @Override
            public void onFinish(String s) {
                view.setFile(new File(filePath));
            }

            @Override
            public void onFailure(String s) {
                view.tip(s);
            }
        });
    }
}
