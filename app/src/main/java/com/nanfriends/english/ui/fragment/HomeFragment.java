package com.nanfriends.english.ui.fragment;

import android.content.Intent;
import android.view.View;

import com.chenchen.collections.utils.SPUtils;
import com.nanfriends.english.R;
import com.nanfriends.english.ui.ListActivity;
import com.nanfriends.english.ui.LoginActivity;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;

@ContentView(R.layout.fragment_home)
public class HomeFragment extends BaseFragment {

    @Event({R.id.listen,R.id.reader,R.id.translate,R.id.writer,R.id.logout})
    private void onClick(View view){
        Intent intent = new Intent(getActivity(),ListActivity.class);
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
                SPUtils.getInstance(getActivity(),"english").clear();
                changeActivity(LoginActivity.class,true);
                return;
        }
        changeActivity(intent,false);
    }
}
