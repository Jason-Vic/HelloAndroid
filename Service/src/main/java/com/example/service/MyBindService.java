package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Vic on 2016/7/22.
 */
public class MyBindService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("TAG","BindService onBind");
        return null;
    }

    @Override
    public void onCreate() {
        Log.d("TAG","BindService onCreate");
        super.onCreate();
    }

    @Override
    public void unbindService(ServiceConnection conn) {
        Log.d("TAG","BindService unbindService");
        super.unbindService(conn);
    }

    @Override
    public void onDestroy() {
        Log.d("TAG","BindService onDestroy");
        super.onDestroy();
    }
}
