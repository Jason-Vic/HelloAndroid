package com.example.asyncload;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private static String url = "http://www.imooc.com/api/teacher?type=4&num=30";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        new NewsAsyncTask().execute(url);
    }

    private List<News> getJasonData(String url) {
        // TODO Auto-generated method stub
        List<News> newsList = new ArrayList<>();

        try {
            String jsonString = readStream(new URL(url).openStream());
            JSONObject jsonObject;
            News news;

            jsonObject = new JSONObject(jsonString);
            JSONArray jsonArray = jsonObject.getJSONArray("data");

            for (int i = 0; i < jsonArray.length(); i++) {
                jsonObject = jsonArray.getJSONObject(i);
                news = new News();
                news.newsIcon = jsonObject.getString("picSmall");
                news.newsTitle = jsonObject.getString("name");
                news.newsContent = jsonObject.getString("description");
                newsList.add(news);
            }
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return newsList;
    }

    private String readStream(InputStream inputStream) {
        InputStreamReader inputStreamReader;
        String result = "";

        try {
            String line;
            inputStreamReader = new InputStreamReader(inputStream, "utf-8");

            BufferedReader bufferedReader = new BufferedReader(
                    inputStreamReader);

            while ((line = bufferedReader.readLine()) != null) {
                result += line;
            }
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    class NewsAsyncTask extends AsyncTask<String, Void, List<News>> {

        @Override
        protected List<News> doInBackground(String... arg0) {
            // TODO Auto-generated method stub
            return getJasonData(arg0[0]);
        }

        @Override
        protected void onPostExecute(List<News> result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);
            NewsAdapter newsAdapter = new NewsAdapter(MainActivity.this, result, listView);
            listView.setAdapter(newsAdapter);

        }

    }
}
