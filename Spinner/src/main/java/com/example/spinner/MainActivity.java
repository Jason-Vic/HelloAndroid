package com.example.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private TextView textView;
    private List<String> list;
    private ArrayAdapter<String> arrayAdapter;
    private SimpleAdapter simpleAdapter;
    private List<Map<String, Object>> datalist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.spinner);
        textView = (TextView) findViewById(R.id.tv);
        datalist = new ArrayList<>();
        list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");
        list.add("Six");
        list.add("Seven");
        // arrayAdapter = new ArrayAdapter<String>(this,
        // android.R.layout.simple_spinner_item, list);
        // arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // spinner.setAdapter(arrayAdapter);
        // spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
        // @Override
        // public void onItemSelected(AdapterView<?> arg0, View arg1,
        // int arg2, long arg3) {
        // // TODO Auto-generated method stub
        // textView.setText("你选择了"+arrayAdapter.getItem(arg2));
        // }
        //
        // @Override
        // public void onNothingSelected(AdapterView<?> arg0) {
        // // TODO Auto-generated method stub
        // Toast.makeText(MainActivity.this, "Canceld",
        // Toast.LENGTH_SHORT).show();
        // }
        // });

        simpleAdapter = new SimpleAdapter(this, getdata(), R.layout.item,
                new String[]{"pic", "text"}, new int[]{R.id.imgView,
                R.id.stv});
        simpleAdapter.setDropDownViewResource(R.layout.item);
        spinner.setAdapter(simpleAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                textView.setText("你选择了" + simpleAdapter.getItem(arg2));
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });
    }

    private List<Map<String, Object>> getdata() {
        // TODO Auto-generated method stub
        for (int i = 0; i < 7; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("pic", R.mipmap.ic_launcher);
            map.put("text", "Test:" + i);
            datalist.add(map);
        }
        return datalist;
    }
}
