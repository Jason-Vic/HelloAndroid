package com.example.broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;




public class MainActivity extends AppCompatActivity {
    private Button sendOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendOne = (Button) findViewById(R.id.sendOne);


        IntentFilter inflater = new IntentFilter("BC_TWO");
        BroRecTwo broRecTwo = new BroRecTwo();
        registerReceiver(broRecTwo, inflater);

        sendOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("msg", "这是一条普通广播");
                intent.setAction("BC_ONE");
                sendBroadcast(intent);
            }
        });
    }
}
