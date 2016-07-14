package com.example.viewflipper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    private ViewFlipper viewFlipper;
    private int[] imgId = {R.drawable.zero, R.drawable.one, R.drawable.two,
            R.drawable.three};
    private float startX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);

        for (int i = 0; i < imgId.length; i++) {
            viewFlipper.addView(getImageView(imgId[i]));
        }

        // viewFlipper.setInAnimation(this, R.anim.left_in);
        // viewFlipper.setOutAnimation(this, R.anim.left_out);
        // viewFlipper.setFlipInterval(3000);
        // viewFlipper.startFlipping();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                startX = event.getX();
                break;
            case MotionEvent.ACTION_MOVE:

                if (event.getX() - startX > 100) {
                    viewFlipper.setInAnimation(this, R.anim.left_in);
                    viewFlipper.setOutAnimation(this, R.anim.left_out);
                    viewFlipper.showPrevious();
                }

                if (startX - event.getX() > 100) {
                    viewFlipper.setInAnimation(this, R.anim.right_in);
                    viewFlipper.setOutAnimation(this, R.anim.right_out);
                    viewFlipper.showNext();
                }
                break;
            case MotionEvent.ACTION_UP:

                break;
        }
        return super.onTouchEvent(event);
    }

    private ImageView getImageView(int imgId) {
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(imgId);
        return imageView;
    }
}
