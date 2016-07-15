package com.example.asyncload;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.LruCache;
import android.widget.ImageView;
import android.widget.ListView;

public class ImageLoader {

    private ImageView imageView;
    private String url;
    private LruCache<String, Bitmap> lruCache;
    private ListView listView;
    private Set<NewsAsyncTask> newsAsyncTaskSet;

    public ImageLoader(ListView listView) {
        this.listView = listView;
        newsAsyncTaskSet = new HashSet<>();
        int maxMemory = (int) Runtime.getRuntime().maxMemory();
        int cacheSize = maxMemory / 4;
        lruCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                //每次存入缓存时使用
                return value.getByteCount();
            }
        };
    }


    public void addBitmapToCache(String url, Bitmap bitmap) {
        if (getBitmapFromCache(url) == null) {
            lruCache.put(url, bitmap);
        }
    }

    public Bitmap getBitmapFromCache(String url) {
        return lruCache.get(url);
    }

    private Handler handler = new Handler() {

        public void handleMessage(Message msg) {
            if (imageView.getTag().equals(url)) {
                imageView.setImageBitmap((Bitmap) msg.obj);
            }
        }
    };

    public void showImageByThread(ImageView imageView, final String url) {
        this.imageView = imageView;
        this.url = url;
        new Thread() {
            public void run() {

                Bitmap bitmap = getBitmapFromURL(url);
                Message message = Message.obtain();
                message.obj = bitmap;
                handler.sendMessage(message);
            }
        }.start();
    }

    public Bitmap getBitmapFromURL(String url) {
        Bitmap bitmap = null;
        InputStream inputStream = null;
        try {
            URL uri = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) uri
                    .openConnection();
            inputStream = new BufferedInputStream(connection.getInputStream());
            bitmap = BitmapFactory.decodeStream(inputStream);

            connection.disconnect();
            return bitmap;

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }


    public void showImageByAsyncTask(ImageView imageView, final String url) {
        Bitmap bitmap = getBitmapFromCache(url);
        if (bitmap == null) {
            imageView.setImageResource(R.mipmap.ic_launcher);
        } else {
            imageView.setImageBitmap(bitmap);
        }
    }

    public void cancelAllTasks() {
        if (newsAsyncTaskSet != null) {
            for (NewsAsyncTask newsAsyncTask : newsAsyncTaskSet) {
                newsAsyncTask.cancel(true);
            }
        }
    }

    private class NewsAsyncTask extends AsyncTask<String, Void, Bitmap> {

        //        public ImageView imageView;
        private String url;

        public NewsAsyncTask(String url) {
//            this.imageView = imageView;
            this.url = url;
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            String url = strings[0];
            Bitmap bitmap = getBitmapFromURL(url);
            if (bitmap != null) {
                addBitmapToCache(url, bitmap);
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            ImageView imageView = (ImageView) listView.findViewWithTag(url);
            if (imageView != null && bitmap != null) {
                imageView.setImageBitmap(bitmap);
            }
            newsAsyncTaskSet.remove(this);
        }
    }


    public void loadImages(int start, int end) {
        for (int i = start; i < end; i++) {
            String url = NewsAdapter.urls[i];
            Bitmap bitmap = getBitmapFromCache(url);
            if (bitmap == null) {
                NewsAsyncTask newsAsyncTask = new NewsAsyncTask(url);
                newsAsyncTask.execute(url);
                newsAsyncTaskSet.add(newsAsyncTask);

            } else {
                ImageView imageView = (ImageView) listView.findViewWithTag(url);
                imageView.setImageBitmap(bitmap);
            }
        }
    }
}
