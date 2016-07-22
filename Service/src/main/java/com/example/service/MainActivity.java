package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Intent intent;
    Intent intentBind;
    private Button buttonStart;
    private Button buttonStop;
    private Button buttonBind;
    private Button buttonPlay;
    private Button buttonPause;
    private Button buttonNext;
    private Button buttonPre;
    private Button buttonUnbind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStart = (Button) findViewById(R.id.start);
        buttonStop = (Button) findViewById(R.id.stop);
        buttonBind = (Button) findViewById(R.id.bind);
        buttonPlay = (Button) findViewById(R.id.play);
        buttonPause = (Button) findViewById(R.id.pause);
        buttonNext = (Button) findViewById(R.id.next);
        buttonPre = (Button) findViewById(R.id.pre);
        buttonUnbind = (Button) findViewById(R.id.unbind);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start:
                intent = new Intent(MainActivity.this, MyStartService.class);
                startService(intent);
                break;
            case R.id.stop:
                stopService(intent);
                break;
            case R.id.bind:
                intentBind = new Intent(MainActivity.this, MyBindService.class);
                bindService(intentBind, null, Service.BIND_AUTO_CREATE);
                break;
            case R.id.play:
                break;
            case R.id.pause:
                break;
            case R.id.next:
                break;
            case R.id.pre:
                break;
            case R.id.unbind:
                unbindService(null);
                break;
        }
    }
}
