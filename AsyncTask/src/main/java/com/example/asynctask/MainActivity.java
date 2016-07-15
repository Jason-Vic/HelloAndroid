package com.example.asynctask;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class MainActivity extends AppCompatActivity {

	private MyAsyncTask myAsyncTask;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		myAsyncTask = new MyAsyncTask();
		myAsyncTask.execute();
	}

	public void startImage(View view) {
		Intent intent = new Intent(MainActivity.this, ImageTest.class);
		startActivity(intent);
	}

	public void startPro(View view) {
		Intent intent = new Intent(MainActivity.this, ProgressBarTest.class);
		startActivity(intent);
	}
}
