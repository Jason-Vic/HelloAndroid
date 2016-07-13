package com.example.viewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by Vic on 2016/7/13.
 */
public class FragmentFour extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        return inflater.inflate(R.layout.item4, container, false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("Destroy!");
    }
}
