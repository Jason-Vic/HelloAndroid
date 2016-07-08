package com.example.simpleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {
    private AutoCompleteTextView completeTextView;
    private MultiAutoCompleteTextView multiAutoCompleteTextView;
    private String[] res = {"hello", "hello1", "hello2", "world", "world1"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        completeTextView = (AutoCompleteTextView) findViewById(R.id.AcTv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, res);
        completeTextView.setAdapter(adapter);
        multiAutoCompleteTextView = (MultiAutoCompleteTextView) findViewById(R.id.MacTv);
        multiAutoCompleteTextView.setAdapter(adapter);
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}
