package com.nanfriends.english.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nanfriends.english.R;
import com.nanfriends.english.ui.fragment.HomeFragment;
import com.nanfriends.english.ui.fragment.MineFragment;
import com.nanfriends.english.ui.fragment.NoteFragment;
import com.nanfriends.english.ui.fragment.ProjectFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_fragment)
public class FragmentActivity extends BaseActivity implements ViewPager.OnPageChangeListener{

    @ViewInject(R.id.bottom)
    LinearLayout linearLayout;
    @ViewInject(R.id.frag_container)
    ViewPager viewPager;

    private List<Fragment> fragments = new ArrayList<>();
    private String[] titles = {"首页","课程","单词","我的"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fragments.add(new HomeFragment());
        fragments.add(new ProjectFragment());
        fragments.add(new NoteFragment());
        fragments.add(new MineFragment());

        viewPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager()));
        viewPager.setOnPageChangeListener(this);
        changeFrag(0);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {
        //state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕
        if (state == 2) {
            setBottom(viewPager.getCurrentItem());
        }
    }

    private void changeFrag(int index){
        viewPager.setCurrentItem(index);
        setBottom(index);
        setTitle(titles[index]);
    }

    private void setBottom(int index){
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            LinearLayout childAt = ((LinearLayout) linearLayout.getChildAt(i));
            ImageView ivIcon = (ImageView) childAt.getChildAt(0);
            TextView tvTitle = (TextView) childAt.getChildAt(1);
            if(index == i){
                ivIcon.setSelected(true);
                tvTitle.setSelected(true);
            }else{
                ivIcon.setSelected(false);
                tvTitle.setSelected(false);
            }
        }
    }
    @Event({R.id.ll_home,R.id.ll_project,R.id.ll_note,R.id.ll_mine})
    private void onClick(View view){
        int index = 0;
        switch (view.getId()){
            case R.id.ll_home:
                index = 0;
                break;
            case R.id.ll_project:
                index = 1;
                break;
            case R.id.ll_note:
                index = 2;
                break;
            case R.id.ll_mine:
                index = 3;
                break;
        }
        changeFrag(index);
    }

    private class MyFragmentAdapter extends FragmentPagerAdapter{

        public MyFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragments.get(i);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}
