package com.example.file;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.edt);
        button = (Button) findViewById(R.id.btn);
        textView = (TextView) findViewById(R.id.tv);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    writeFile(editText.getText().toString());
                    textView.setText(readFile());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void writeFile(String content) throws IOException {
        FileOutputStream outputStream = openFileOutput("text", MODE_APPEND);
        outputStream.write(content.getBytes());
        outputStream.close();
    }


    public String readFile() throws IOException {
        String content = null;
        FileInputStream fileInputStream = openFileInput("text");
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = fileInputStream.read(buffer)) != -1) {
            arrayOutputStream.write(buffer, 0, len);
        }
        content = arrayOutputStream.toString();
        fileInputStream.close();
        fileInputStream.close();

        return content;
    }
}
