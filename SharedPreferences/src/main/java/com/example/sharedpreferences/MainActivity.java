package com.example.sharedpreferences;

import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences
//                (MainActivity.this
//        );
        SharedPreferences sharedPreferences = getSharedPreferences("myPre", MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("name", "Vic");
        edit.putInt("age", 22);
        edit.putLong("time", System.currentTimeMillis());
        edit.putBoolean("default", true);
        edit.commit();
        edit.remove("default");
        edit.commit();
        System.out.println(sharedPreferences.getString("name", ""));
        System.out.println(sharedPreferences.getInt("age", 0));
    }
}
