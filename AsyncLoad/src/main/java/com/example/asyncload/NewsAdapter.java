package com.example.asyncload;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class NewsAdapter extends BaseAdapter implements AbsListView.OnScrollListener {

    private List<News> newsList;
    private LayoutInflater layoutInflater;
    private ImageLoader imageLoader;
    private int start, end;
    public static String[] urls;
    private boolean firstIn;

    public NewsAdapter(Context context, List<News> newsList, ListView listView) {
        this.newsList = newsList;
        layoutInflater = LayoutInflater.from(context);
        imageLoader = new ImageLoader(listView);
        urls = new String[newsList.size()];

        for (int i = 0; i < newsList.size(); i++) {
            urls[i] = newsList.get(i).newsIcon;
        }
        firstIn = true;
        listView.setOnScrollListener(this);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return newsList.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return newsList.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }

    @Override
    public View getView(int arg0, View arg1, ViewGroup arg2) {
        // TODO Auto-generated method stub

        ViewHolder viewHolder = null;

        if (arg1 == null) {
            viewHolder = new ViewHolder();
            arg1 = layoutInflater.inflate(R.layout.item, null);
            viewHolder.imageIcon = (ImageView) arg1.findViewById(R.id.img);
            viewHolder.textTitle = (TextView) arg1.findViewById(R.id.tvTitle);
            viewHolder.textContent = (TextView) arg1
                    .findViewById(R.id.tvContent);
            arg1.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) arg1.getTag();
        }

        viewHolder.imageIcon.setImageResource(R.mipmap.ic_launcher);
        String url = newsList.get(arg0).newsIcon;
        viewHolder.imageIcon.setTag(url);
//        new ImageLoader().showImageByThread(viewHolder.imageIcon, url);
        imageLoader.showImageByAsyncTask(viewHolder.imageIcon, url);
        viewHolder.textTitle.setText(newsList.get(arg0).newsTitle);
        viewHolder.textContent.setText(newsList.get(arg0).newsContent);
        return arg1;
    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == SCROLL_STATE_IDLE) {
            //加载可见项
            imageLoader.loadImages(start, end);
        } else {
            //停止任务
            imageLoader.cancelAllTasks();
        }
    }

    @Override
    public void onScroll(AbsListView absListView, int i, int i1, int i2) {
        start = i;
        end = i + i1;
        if (firstIn && i1 > 0) {
            imageLoader.loadImages(start, end);
            firstIn = false;
        }
    }

    class ViewHolder {
        TextView textTitle, textContent;
        ImageView imageIcon;
    }

}
