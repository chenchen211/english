package com.nanfriends.english.ui.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.chenchen.collections.utils.SPUtils;
import com.nanfriends.english.R;
import com.nanfriends.english.ui.LoginActivity;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.fragment_mine)
public class MineFragment extends BaseFragment {
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Event(R.id.logout)
    private void onClick(View view){
        switch (view.getId()){
            case R.id.logout:
                SPUtils.getInstance(getActivity(),"english").clear();
                changeActivity(LoginActivity.class,true);
                break;
        }
    }
}
