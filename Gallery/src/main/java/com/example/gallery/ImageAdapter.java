package com.example.gallery;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class ImageAdapter extends BaseAdapter {

	private int[] ImageId;
	private Context context;

	public ImageAdapter(int[] ImageId, Context context) {
		this.ImageId = ImageId;
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return Integer.MAX_VALUE;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return ImageId[arg0 % ImageId.length];
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0 % ImageId.length;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		ImageView imageView = new ImageView(context);
		imageView.setBackgroundResource(ImageId[arg0 % ImageId.length]);
		imageView.setLayoutParams(new Gallery.LayoutParams(200, 150));
		imageView.setScaleType(ScaleType.CENTER_CROP);
		return imageView;
	}

}
