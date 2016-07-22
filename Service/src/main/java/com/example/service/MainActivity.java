package com.example.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Intent intent;
    Intent intentBind;
    MyBindService bindService;

    private Button buttonStart;
    private Button buttonStop;
    private Button buttonBind;
    private Button buttonPlay;
    private Button buttonPause;
    private Button buttonNext;
    private Button buttonPre;
    private Button buttonUnbind;


    ServiceConnection connection = new ServiceConnection() {
        @Override
        //当启动源和Service成功连接之后会自动调用这个方法
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            bindService = ((MyBindService.MyBinder) iBinder).getService();
        }

        @Override
        //当启动源和Service的连接意外丢失的时候会调用这个方法
        //比如Service崩溃了或者被强行杀死了
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

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

        buttonStart.setOnClickListener(this);
        buttonStop.setOnClickListener(this);
        buttonBind.setOnClickListener(this);
        buttonPlay.setOnClickListener(this);
        buttonPause.setOnClickListener(this);
        buttonNext.setOnClickListener(this);
        buttonPre.setOnClickListener(this);
        buttonUnbind.setOnClickListener(this);

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
                bindService(intentBind, connection, Service.BIND_AUTO_CREATE);
                break;
            case R.id.play:
                bindService.play();
                break;
            case R.id.pause:
                bindService.pause();
                break;
            case R.id.next:
                bindService.next();
                break;
            case R.id.pre:
                bindService.pre();
                break;
            case R.id.unbind:
                unbindService(connection);
                break;
        }
    }


    @Override
    protected void onDestroy() {
        stopService(intentBind);
        unbindService(connection);
        super.onDestroy();
    }
}
