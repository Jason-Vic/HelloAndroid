package com.example.baseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;


/**
 * Created by Vic on 2016/7/14.
 */
public class MyAdapter extends BaseAdapter {

    private List<Item> itemList;
    private LayoutInflater inflater;

    public MyAdapter(Context context, List<Item> itemList) {
        this.itemList = itemList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int i) {
        return itemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        int flag = 2;
        //没有利用ListView的缓存机制,不应该使用
        if (flag == 0) {
            View mView = inflater.inflate(R.layout.item, null);
            ImageView imageView = (ImageView) mView.findViewById(R.id.img);
            TextView textTitle = (TextView) mView.findViewById(R.id.tvTitle);
            TextView textContent = (TextView) mView.findViewById(R.id.tvContent);

            imageView.setImageResource(itemList.get(i).ItemImageId);
            textTitle.setText(itemList.get(i).ItemTitle);
            textContent.setText(itemList.get(i).ItemContent);
            return mView;
        } else if (flag == 1) {
            if (view == null) {
                view = inflater.inflate(R.layout.item, null);
            }
            ImageView imageView = (ImageView) view.findViewById(R.id.img);
            TextView textTitle = (TextView) view.findViewById(R.id.tvTitle);
            TextView textContent = (TextView) view.findViewById(R.id.tvContent);
            imageView.setImageResource(itemList.get(i).ItemImageId);
            textTitle.setText(itemList.get(i).ItemTitle);
            textContent.setText(itemList.get(i).ItemContent);
            return view;
        } else {
            ViewHolder viewHolder;
            if (view == null) {
                viewHolder = new ViewHolder();
                view = inflater.inflate(R.layout.item, null);
                viewHolder.imageView = (ImageView) view.findViewById(R.id.img);
                viewHolder.textTitle = (TextView) view.findViewById(R.id.tvTitle);
                viewHolder.textContent = (TextView) view.findViewById(R.id.tvContent);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.imageView.setImageResource(itemList.get(i).ItemImageId);
            viewHolder.textTitle.setText(itemList.get(i).ItemTitle);
            viewHolder.textContent.setText(itemList.get(i).ItemContent);
            return view;
        }
    }


    class ViewHolder {
        public ImageView imageView;
        public TextView textTitle;
        public TextView textContent;

    }
}
