package com.example.baseadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        List<Item> itemList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            itemList.add(new Item(
                    R.mipmap.ic_launcher,
                    "Hello World " + i,
                    "Title" + i
            ));
        }

        myAdapter = new MyAdapter(this, itemList);
        listView.setAdapter(myAdapter);
    }
}
