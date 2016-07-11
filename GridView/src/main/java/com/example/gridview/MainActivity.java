package com.example.gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private GridView gridView;
    private List<Map<String, Object>> dataList;
    private int[] icon = {R.drawable.address_book, R.drawable.calendar,
            R.drawable.camera, R.drawable.clock, R.drawable.games_control,
            R.drawable.messenger, R.drawable.ringtone, R.drawable.settings,
            R.drawable.speech_balloon, R.drawable.weather, R.drawable.browser,
            R.drawable.youtube};
    private String[] iconName = {"通讯录", "日历", "相机", "时钟", "游戏", "信息", "铃声",
            "设置", "语音", "天气", "浏览器", "视频"};
    private SimpleAdapter simpleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.gridView);
        dataList = new ArrayList<>();
        simpleAdapter = new SimpleAdapter(this, getdata(), R.layout.item,
                new String[]{"pic", "text"}, new int[]{R.id.imgView,
                R.id.tv});
        gridView.setAdapter(simpleAdapter);
        gridView.setOnItemClickListener(this);
    }

    private List<Map<String, Object>> getdata() {
        // TODO Auto-generated method stub
        for (int i = 0; i < icon.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("pic", icon[i]);
            map.put("text", iconName[i]);
            dataList.add(map);
        }
        return dataList;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, "我是" + iconName[i], Toast.LENGTH_SHORT).show();
    }
}
