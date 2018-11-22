package com.nanfriends.english.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.xutils.x;

public class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return  x.view().inject(this, inflater, container);
    }
    public void changeActivity(Intent intent, boolean isFinish){
        startActivity(intent);
        if(isFinish){
            this.getActivity().finish();
        }
    }
    public void changeActivity(Class<?> activity, boolean isFinish){
        Intent intent = new Intent(getActivity(),activity);
        startActivity(intent);
        if(isFinish){
           this.getActivity().finish();
        }
    }
}
