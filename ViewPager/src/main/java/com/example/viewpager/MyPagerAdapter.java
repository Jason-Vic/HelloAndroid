package com.example.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Vic on 2016/7/13.
 */
public class MyPagerAdapter extends PagerAdapter {


    private List<View> viewList;
    private List<String> titleList;

    public MyPagerAdapter(List<View> viewList, List<String> titleList) {
        this.viewList = viewList;
        this.titleList = titleList;
    }

    //页卡数量
    @Override
    public int getCount() {
        return viewList.size();
    }

    //是否来自于一个对象
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    //实例化一个页卡
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewList.get(position));
        return viewList.get(position);
    }

    //销毁一个页卡
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewList.get(position));
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
