package com.example.testautoscrollviewpager;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.testautoscrollviewpager.widget.AutoScrollLoopViewPager;
import com.example.testautoscrollviewpager.widget.LoopViewPager.OnUpdateTitleListener;

public class MainActivity extends Activity {

	private String[] args = {
			"http://img0.bdstatic.com/img/image/shouye/sheying0717.jpg",
			"http://img0.bdstatic.com/img/image/shouye/bizhi0717.jpg",
			"http://img0.bdstatic.com/img/image/shouye/mingxing0610.jpg",
			"http://img0.bdstatic.com/img/image/shouye/chongwu0717.jpg",
			"http://img0.bdstatic.com/img/image/shouye/dongman0610.jpg",
			"http://img0.bdstatic.com/img/image/shouye/touxiang0605.jpg" };
	TextView textView = null;
	private String[] text = { "摄影", "壁纸", "明星", "宠物", "动漫", "头像" };
	ArrayList<String> urls = new ArrayList<>();
	SplashShowAdapter adapter;
	AutoScrollLoopViewPager viewpager ;
	CirclePageIndicator cpi;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 viewpager = (AutoScrollLoopViewPager) findViewById(R.id.view_pager);
		 cpi = (CirclePageIndicator) findViewById(R.id.cpi_indicator);
		textView = (TextView) findViewById(R.id.tv_title);
		adapter = new SplashShowAdapter(this, urls);
		Button btn = (Button) findViewById(R.id.button1);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				urls.clear();
				for (int i = 0; i < 6; i++) {
					urls.add(args[i]);
				}
				
				adapter.notifyDataSetChanged();
				viewpager.setAdapter(adapter);
				viewpager.startAutoScroll();
				cpi.setViewPager(viewpager);
				
				
			}
		});


		viewpager.setOnUpdateTitleListener(new OnUpdateTitleListener() {

			@Override
			public void updateTitle(int position) {
					textView.setText(text[position]);					
			}
		});

	}
}
