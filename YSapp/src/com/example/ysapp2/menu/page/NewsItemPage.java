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
	List<BasePage> newsPages;//������е�������Ϣ
	//tabpageindicator����ʾ����
	 private static final String[] TITLE = new String[] { "ͷ��","����", "��ҩָ��"};  
	
	public NewsItemPage(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View initView(Context context) {
		// TODO Auto-generated method stub
//		TextView tv=new TextView(context);
//		tv.setText("���Ž���");
		//
	View v=	View.inflate(context, R.layout.news_item_page, null);
	indicator=(TabPageIndicator) v.findViewById(R.id.indicator);
	vp=(ViewPager) v.findViewById(R.id.pager);
		return v;
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		System.out.println("ִ��itempage��initdata");
		newsPages=new ArrayList<BasePage>();
		newsPages.add(new TopicPage(context));
		newsPages.add(new MoneyPage(context));
		newsPages.add(new WomanPage(context));
		
		//vp��������Դ
		vp.setAdapter(new MyPageAdapter());
		
		//indicator��vp����
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
