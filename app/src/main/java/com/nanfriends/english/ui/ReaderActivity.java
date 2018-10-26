package com.nanfriends.english.ui;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.nanfriends.english.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.activity_reader)
public class ReaderActivity extends BaseActivity {
    @ViewInject(R.id.pdfView)
    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pdfView.fromAsset("android.pdf")
                .defaultPage(0)
                .onPageChange(new OnPageChangeListener() {
                    @Override
                    public void onPageChanged(int page, int pageCount) {
                        setTitle(String.format("%s %s /%s","这里是标题",page+1,pageCount));
                    }
                })
                .enableAnnotationRendering(true)
                .swipeHorizontal(false)
                .spacing(10)
                .onPageError(new OnPageErrorListener() {
                    @SuppressLint("LongLogTag")
                    @Override
                    public void onPageError(int page, Throwable t) {
                        Log.e("chenchen", "onPageError: Cannot load page"+page );
                    }
                })
                .load();
    }
    @Event({R.id.iv_title_right})
    private void onClick(View view){
        switch (view.getId()){
            case R.id.iv_title_right:
                changeActivity(ProblemActivity.class,false);
                break;
        }
    }
}
