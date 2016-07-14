package com.example.gallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity implements AdapterView
        .OnItemSelectedListener, ViewSwitcher.ViewFactory {
    private int[] ImageId = {R.drawable.one, R.drawable.two, R.drawable.three,
            R.drawable.four, R.drawable.five, R.drawable.six, R.drawable.seven,
            R.drawable.eight};
    private Gallery gallery;
    private ImageAdapter imageAdapter;
    private ImageSwitcher imageSwitcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gallery = (Gallery) findViewById(R.id.gallery);
        imageSwitcher = (ImageSwitcher) findViewById(R.id.imgSw);

        imageAdapter = new ImageAdapter(ImageId, this);
        gallery.setAdapter(imageAdapter);
        gallery.setOnItemSelectedListener(this);

        imageSwitcher.setFactory(this);
        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out));
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                               long arg3) {
        // TODO Auto-generated method stub
        // imageView.setBackgroundResource(ImageId[arg0 % ImageId.length]);
        imageSwitcher.setBackgroundResource(ImageId[arg2 % ImageId.length]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public View makeView() {
        // TODO Auto-generated method stub
        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        return imageView;
    }
}
