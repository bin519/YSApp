package com.example.ysapp2;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

public class ViewPagerActivity extends Activity {

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		//声明一个偏好设置对象
		SharedPreferences sharedPreferences=getSharedPreferences("save",0);
	  //向偏好设置文件中保存用户浏览状态
		Editor editor=sharedPreferences.edit();
		editor.putBoolean("isFrist", false);
		editor.commit();
	}
	class MyAdapter extends PagerAdapter{
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}
		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0==arg1;
		}
		@Override
		public Object instantiateItem(View container, int position) {
			// TODO Auto-generated method stub
			//获取当前引导页
			View view=list.get(position);
			((ViewPager)container).addView(view);
			return view;			
		}
		@Override
		public void destroyItem(View container, int position, Object object) {
			// TODO Auto-generated method stub
			View view =list.get(position);
		    ((ViewPager)container).removeView(view);
		}
	}
//声明一个viewpage控件
	ViewPager viewpager;
//声明一个LayourtInflater对象
	LayoutInflater mInflater;
//声明布局文件v1v2v3 
	View b0,b1,b2,b3,b4;
//声明一个ArrayList，存放引导页
	ArrayList<View> list;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_pager);
		//取出用户保存的浏览状态
		SharedPreferences sharedPreferences=getSharedPreferences("save",0);
		boolean isFristTime=sharedPreferences.getBoolean("isFrist",true);
		if(!isFristTime){
			Intent intent=new Intent(ViewPagerActivity.this,MainActivity.class);
			startActivity(intent);
			finish();
		}
		
		mInflater = LayoutInflater.from(this);
		//通过mInflater去初始化布局文件、
		b0=mInflater.inflate(R.layout.viewpage1, null);
		b1=mInflater.inflate(R.layout.viewpage2, null);
		b2=mInflater.inflate(R.layout.viewpage3, null);
		b3=mInflater.inflate(R.layout.viewpage4, null);
		b4=mInflater.inflate(R.layout.viewpage5, null);
		//初始化list
		list =new ArrayList<View>();
		list.add(b0);
		list.add(b1);
		list.add(b2);
		list.add(b3);
		list.add(b4);
		viewpager=(ViewPager)findViewById(R.id.viewpager1);
		viewpager.setAdapter(new MyAdapter());
		
	}
	public void click(View v){
		Intent intent=new Intent(ViewPagerActivity.this,MainActivity.class);
		startActivity(intent);
	}
}