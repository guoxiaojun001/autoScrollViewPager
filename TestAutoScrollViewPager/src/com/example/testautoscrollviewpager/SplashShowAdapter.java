/**
 * Copyright (C) 2014 HongCheng System Inc.
 * This file write by fattoliu in 2014-4-28,mail:fantasyhaha512513@gmail.com
 */
package com.example.testautoscrollviewpager;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * 循环播放图片ViewPager适配器
 * 
 * @author fattoliu
 * @version V1.0
 * @date 2014-4-28下午10:32:23
 */
@SuppressLint("InflateParams")
public class SplashShowAdapter extends PagerAdapter {

	private Context mContext = null;
	private ArrayList<String> urls = null;

	/**
	 * 构造函数
	 * 
	 * @param context
	 * @param imagesUrl
	 * @param imageLoader
	 * @param options
	 */
	public SplashShowAdapter(Context context, ArrayList<String> urls) {
		this.mContext = context;
		this.urls = urls;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View) object);
	}

	@Override
	public int getCount() {
		return urls.size();
	}

	@Override
	public Object instantiateItem(ViewGroup view, int position) {
		View imageLayout = LayoutInflater.from(mContext).inflate(R.layout.item_ad, null);
		imageLayout.setId(position);
		assert imageLayout != null;
		ImageView imageView = (ImageView) imageLayout.findViewById(R.id.iv);
		Picasso.with(mContext)
		.load(urls.get(position))
		.placeholder(mContext.getResources().getDrawable(R.drawable.ic_launcher))
		.into(imageView);
		view.addView(imageLayout, 0);
		return imageLayout;
	}

	
	
	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view.equals(object);
	}

	@Override
	public void restoreState(Parcelable state, ClassLoader loader) {
	}

	@Override
	public Parcelable saveState() {
		return null;
	}

}
