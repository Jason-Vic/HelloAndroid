package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Vic on 2016/7/22.
 */
public class MyStartService extends Service{
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("TAG","Service onBind");
        return null;
    }

    @Override
    public void onCreate() {
        Log.d("TAG","Service onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("TAG","Service onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d("TAG","Service onDestroy");
        super.onDestroy();
    }
}
