package com.example.asynctask;

import android.os.AsyncTask;
import android.util.Log;

public class MyAsyncTask extends AsyncTask<Void, Void, Void> {

	@Override
	protected Void doInBackground(Void... arg0) {
		// TODO Auto-generated method stub
		Log.d("Async", "doInBackground");
		publishProgress();
		return null;
	}

	@Override
	protected void onPostExecute(Void result) {
		// TODO Auto-generated method stub
		Log.d("Async", "onPostExecute");
		super.onPostExecute(result);
	}

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		Log.d("Async", "onPreExecute");
		super.onPreExecute();
	}

	@Override
	protected void onProgressUpdate(Void... values) {
		// TODO Auto-generated method stub
		Log.d("Async", "onProgressUpdate");
		super.onProgressUpdate(values);
	}

}
