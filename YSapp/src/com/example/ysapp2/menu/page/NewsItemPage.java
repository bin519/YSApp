package com.example.ysapp2.menu.page;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.example.ysapp2.R;
import com.example.ysapp2.ViewPagerActivity;
import com.example.ysapp2.base.BasePage;
import com.example.ysapp2.page.MoneyPage;
import com.example.ysapp2.page.TopicPage;
import com.example.ysapp2.page.WomanPage;
import com.viewpagerindicator.TabPageIndicator;

public class NewsItemPage extends BasePage {

	TabPageIndicator   indicator;//
	ViewPager  vp;//vp
	List<BasePage> newsPages;//存放所有的新闻信息
	//tabpageindicator：显示数据
	 private static final String[] TITLE = new String[] { "头条","养生", "用药指南"};  
	
	public NewsItemPage(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View initView(Context context) {
		// TODO Auto-generated method stub
//		TextView tv=new TextView(context);
//		tv.setText("新闻界面");
		//
	View v=	View.inflate(context, R.layout.news_item_page, null);
	indicator=(TabPageIndicator) v.findViewById(R.id.indicator);
	vp=(ViewPager) v.findViewById(R.id.pager);
		return v;
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		System.out.println("执行itempage的initdata");
		newsPages=new ArrayList<BasePage>();
		newsPages.add(new TopicPage(context));
		newsPages.add(new MoneyPage(context));
		newsPages.add(new WomanPage(context));
		
		//vp设置数据源
		vp.setAdapter(new MyPageAdapter());
		
		//indicator和vp关联
		indicator.setViewPager(vp);
		
	}
	
	class MyPageAdapter extends PagerAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return newsPages.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0==arg1;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			// TODO Auto-generated method stub
		  container.removeView(newsPages.get(position).getView());
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// TODO Auto-generated method stub
			container.addView(newsPages.get(position).getView());
			return newsPages.get(position).getView();
		}

		@Override
		public CharSequence getPageTitle(int position) {
			// TODO Auto-generated method stub
			return TITLE[position];
		}
		
		
		
	}
	

}
