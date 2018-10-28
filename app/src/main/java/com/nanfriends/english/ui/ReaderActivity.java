package com.nanfriends.english.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.nanfriends.english.R;
import com.nanfriends.english.bean.Question;
import com.nanfriends.english.contract.ReaderContract;
import com.nanfriends.english.presenter.ReaderPresenter;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.io.File;

@ContentView(R.layout.activity_reader)
public class ReaderActivity extends BaseActivity implements ReaderContract.View {
    @ViewInject(R.id.pdfView)
    PDFView pdfView;

    private Question.DataBean data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("阅读理解");
        showIcon();
        Intent intent = getIntent();
        data = (Question.DataBean) intent.getSerializableExtra("data");
        if(data!=null){
            ReaderPresenter presenter = new ReaderPresenter(this);
            presenter.download(data.getPath());
        }
    }
    @Event({R.id.iv_title_right})
    private void onClick(View view){
        switch (view.getId()){
            case R.id.iv_title_right:
                changeActivity(ProblemActivity.class,false);
                break;
        }
    }

    @Override
    public void setFile(File file) {
        if(!file.exists()){
            tip("文章加载失败");
        }

        pdfView.fromFile(file)
                .defaultPage(0)
                .onPageChange(new OnPageChangeListener() {
                    @Override
                    public void onPageChanged(int page, int pageCount) {
                        setTitle(String.format("%s %s /%s",data.getTitle(),page+1,pageCount));
                    }
                })
                .enableAnnotationRendering(true)
                .swipeHorizontal(false)
                .spacing(10)
                .onPageError(new OnPageErrorListener() {
                    @SuppressLint("LongLogTag")
                    @Override
                    public void onPageError(int page, Throwable t) {
                        tip("文章加载出错第【"+page+"】页。错误原因："+t.getMessage());
                    }
                })
                .load();
    }

    @Override
    public void tip(String tip) {
        Toast.makeText(this, tip, Toast.LENGTH_SHORT).show();
    }
}
