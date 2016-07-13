package com.example.viewpager;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements ViewPager.OnPageChangeListener {
    private List<View> viewList;
    private ViewPager viewPager;
    private PagerTabStrip pagerTabStrip;
    private List<String> titleList;
    private List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        viewList = new ArrayList<>();
        View view1 = View.inflate(this, R.layout.item1, null);
        View view2 = View.inflate(this, R.layout.item2, null);
        View view3 = View.inflate(this, R.layout.item3, null);
        View view4 = View.inflate(this, R.layout.item4, null);

        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        viewList.add(view4);

        fragmentList = new ArrayList<>();
        fragmentList.add(new FragmentOne());
        fragmentList.add(new FragmentTwo());
        fragmentList.add(new FragmentThree());
        fragmentList.add(new FragmentFour());

        titleList = new ArrayList<>();
        titleList.add("One Page");
        titleList.add("Two Page");
        titleList.add("Three Page");
        titleList.add("Four Page");

        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(viewList, titleList);
//        viewPager.setAdapter(myPagerAdapter);

        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter
                (getSupportFragmentManager(), fragmentList);

//        viewPager.setAdapter(myFragmentPagerAdapter);

        MyFragmentStatePagerAdapter myFragmentStatePagerAdapter = new MyFragmentStatePagerAdapter
                (getSupportFragmentManager(), fragmentList);

        viewPager.setAdapter(myFragmentStatePagerAdapter);
        viewPager.setOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Toast.makeText(this, (position+1)+" View", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
