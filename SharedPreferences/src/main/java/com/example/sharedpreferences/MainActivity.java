package com.example.sharedpreferences;

import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText UserName,UserPass;
    CheckBox chk;
    SharedPreferences pref;
    SharedPreferences.Editor edtior;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences
//                (MainActivity.this
//        );
//        SharedPreferences sharedPreferences = getSharedPreferences("myPre", MODE_PRIVATE);
//        SharedPreferences.Editor edit = sharedPreferences.edit();
//        edit.putString("name", "Vic");
//        edit.putInt("age", 22);
//        edit.putLong("time", System.currentTimeMillis());
//        edit.putBoolean("default", true);
//        edit.commit();
//        edit.remove("default");
//        edit.commit();
//        System.out.println(sharedPreferences.getString("name", ""));
//        System.out.println(sharedPreferences.getInt("age", 0));
        UserName = (EditText) findViewById(R.id.userName);
        UserPass = (EditText) findViewById(R.id.userPasswd);
        chk = (CheckBox) findViewById(R.id.chkSaveName);
        pref = getSharedPreferences("UserInfo", MODE_PRIVATE);
        edtior = pref.edit();
        String name = pref.getString("userName", "");
        if (name == null) {
            chk.setChecked(false);
        } else {
            chk.setChecked(true);
            UserName.setText(name);
        }
    }

    public void doClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                String name = UserName.getText().toString().trim();
                String pass = UserPass.getText().toString().trim();
                if ("admin".equals(name) && "123456".equals(pass)) {
                    if (chk.isChecked()) {
                        edtior.putString("userName", name);
                        edtior.commit();

                    } else {
                        edtior.remove("userName");
                        edtior.commit();
                    }
                    Toast.makeText(MainActivity.this, "登陆成功", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "禁止登陆", Toast.LENGTH_LONG).show();
                }
                break;

            default:
                break;
        }
    }
}
