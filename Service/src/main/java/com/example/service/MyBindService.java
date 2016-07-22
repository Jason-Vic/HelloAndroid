package com.example.service;

import android.Manifest;
import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Vic on 2016/7/22.
 */
public class MyBindService extends Service {


    public class MyBinder extends Binder {
        public MyBindService getService() {
            return MyBindService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("TAG", "BindService onBind");
        return new MyBinder();
    }

    @Override
    public void onCreate() {
        Log.d("TAG", "BindService onCreate");
        super.onCreate();
    }

    @Override
    public void unbindService(ServiceConnection conn) {
        Log.d("TAG", "BindService unbindService");
        super.unbindService(conn);
    }

    @Override
    public void onDestroy() {
        Log.d("TAG", "BindService onDestroy");
        super.onDestroy();
    }


    public void play() {
        Toast.makeText(this, "Play!", Toast.LENGTH_SHORT).show();
    }

    public void pause() {
        Toast.makeText(this, "Pause!", Toast.LENGTH_SHORT).show();
    }

    public void next() {
        Toast.makeText(this, "Next!", Toast.LENGTH_SHORT).show();
    }

    public void pre() {
        Toast.makeText(this, "pre!", Toast.LENGTH_SHORT).show();
    }
}
