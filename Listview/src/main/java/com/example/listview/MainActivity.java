package com.example.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AbsListView.OnScrollListener {
    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    private SimpleAdapter simpleAdapter;
    private List<Map<String, Object>> datalist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lv);
        String[] data = {"One", "Two", "Three", "Four", "Five", "Six", "Seven"};
        datalist = new ArrayList<Map<String, Object>>();
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        simpleAdapter = new SimpleAdapter(this, getDatalist(), R.layout.layout, new String[]{"pic", "text"}, new int[]{R.id.pic, R.id.text});
        listView.setAdapter(arrayAdapter);
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(this);
        listView.setOnScrollListener(this);
    }

    private List<Map<String, Object>> getDatalist() {

        for (int i = 0; i < 20; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("pic", R.mipmap.ic_launcher);
            map.put("text", "Hello" + i);
            datalist.add(map);
        }
        return datalist;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String text = listView.getItemAtPosition(i) + "";
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {

    }

    @Override
    public void onScroll(AbsListView absListView, int i, int i1, int i2) {
        switch (i) {
            case SCROLL_STATE_FLING:
                //Toast.makeText(MainActivity.this,"Fling",Toast.LENGTH_SHORT).show();
                //Map<String, Object> map = new HashMap<>();
                //map.put("text", "New");
                //map.put("pic", R.mipmap.ic_launcher);
                //datalist.add(map);
                //simpleAdapter.notifyDataSetChanged();
                break;
            case SCROLL_STATE_IDLE:
                //Toast.makeText(MainActivity.this,"Idle",Toast.LENGTH_SHORT).show();
                break;
            case SCROLL_STATE_TOUCH_SCROLL:
                //Toast.makeText(MainActivity.this,"Scroll",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
