package com.example.progressbar;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ProgressBar progressBar;
    private Button inc;
    private Button red;
    private Button reset;
    private Button show;
    private TextView tv;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.proBar);
        inc = (Button) findViewById(R.id.inc);
        red = (Button) findViewById(R.id.red);
        reset = (Button) findViewById(R.id.reset);
        tv = (TextView) findViewById(R.id.tv);
        show = (Button) findViewById(R.id.show);

        int firstPro = progressBar.getProgress();
        int secondPro = progressBar.getSecondaryProgress();
        int max = progressBar.getMax();
        tv.setText("The progress is " + (int) (firstPro / (float) max * 100) + "%|" + (int)
                (secondPro / (float) max * 100) + "%");
        inc.setOnClickListener(this);
        red.setOnClickListener(this);
        reset.setOnClickListener(this);
        show.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.inc:
                progressBar.incrementProgressBy(5);
                progressBar.incrementSecondaryProgressBy(10);
                break;
            case R.id.red:
                progressBar.incrementProgressBy(-10);
                progressBar.incrementSecondaryProgressBy(-5);
                break;
            case R.id.reset:
                progressBar.setProgress(0);
                progressBar.setSecondaryProgress(0);
                break;
            case R.id.show:
                progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setTitle("Jason-Vic");
                progressDialog.setMessage("WelCome To My ProcessBar!");
                progressDialog.setIcon(R.mipmap.ic_launcher);

                progressDialog.setMax(100);
                progressDialog.incrementProgressBy(50);
                progressDialog.setIndeterminate(false);

                progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new
                        DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "Thanks", Toast.LENGTH_SHORT)
                                        .show();
                            }
                        });

                progressDialog.setCancelable(true);
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.show();

                break;
        }
        tv.setText("The progress is " + (int) (progressBar.getProgress() / (float) progressBar
                .getMax() * 100) + "%|" + (int)
                (progressBar.getSecondaryProgress() / (float) progressBar.getMax() * 100) + "%");
    }
}
