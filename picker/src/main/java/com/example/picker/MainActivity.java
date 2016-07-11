package com.example.picker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private DatePicker datePicker;

    private TimePicker timePicker;
    private Calendar calendar;
    private TextView textView;

    private int year;
    private int month;
    private int day;

    private int hour;
    private int minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        textView = (TextView) findViewById(R.id.tv);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);
        textView.setText(year + "-" + month + "-" + day + " " + hour + ":"
                + minute);

        datePicker.init(year, calendar.get(Calendar.MONTH), day,
                new DatePicker.OnDateChangedListener() {

                    @Override
                    public void onDateChanged(DatePicker arg0, int arg1,
                                              int arg2, int arg3) {
                        // TODO Auto-generated method stub
                        textView.setText(arg1 + "-" + (arg2 + 1) + "-"
                                + arg3);
                    }
                });

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {

            @Override
            public void onTimeChanged(TimePicker arg0, int arg1, int arg2) {
                // TODO Auto-generated method stub
                textView.setText(arg1 + ":" + arg2);
            }
        });

        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub
                textView.setText(arg1 + "-" + (arg2 + 1) + "-" + arg3);
            }
        }, year, calendar.get(Calendar.MONTH), day).show();

        new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {

            @Override
            public void onTimeSet(TimePicker arg0, int arg1, int arg2) {
                // TODO Auto-generated method stub
                textView.setText(arg1 + ":" + arg2);
            }
        }, hour, minute, true).show();
    }
}
