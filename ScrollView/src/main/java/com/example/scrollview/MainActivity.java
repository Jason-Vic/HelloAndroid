package com.example.scrollview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;
    private ScrollView scrollView;

    private Button down;
    private Button up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        up = (Button) findViewById(R.id.UpBtn);
        down = (Button) findViewById(R.id.DownBtn);

        up.setOnClickListener(this);
        down.setOnClickListener(this);

        textView = (TextView) findViewById(R.id.text);
        textView.setText(R.string.text);

        scrollView = (ScrollView) findViewById(R.id.sv);
        scrollView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                // TODO Auto-generated method stub

                switch (arg1.getAction()) {

                    case MotionEvent.ACTION_MOVE:
                        if (scrollView.getScrollY() <= 0) {
                            Toast.makeText(MainActivity.this, "On Top",
                                    Toast.LENGTH_SHORT).show();
                        }
                        if (scrollView.getChildAt(0).getMeasuredHeight() == scrollView
                                .getHeight() + scrollView.getScrollY()) {
                            Toast.makeText(MainActivity.this, "On Bottom",
                                    Toast.LENGTH_SHORT).show();
                            textView.append(getResources().getString(R.string.text));
                        }

                        break;
                }
                return false;
            }
        });
    }

    @Override
    public void onClick(View arg0) {
        // TODO Auto-generated method stub
        switch (arg0.getId()) {
            case R.id.UpBtn:
                scrollView.scrollBy(0, -30);
                break;
            case R.id.DownBtn:
                scrollView.scrollBy(0, 30);
                break;
        }
    }
}
