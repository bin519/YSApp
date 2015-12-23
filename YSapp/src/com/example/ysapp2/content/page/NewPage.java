package com.example.ysapp2.content.page;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.ysapp2.R;
import com.example.ysapp2.base.BasePage;
import com.example.ysapp2.menu.page.ClearSessionPage;
import com.example.ysapp2.menu.page.NewsItemPage;
import com.example.ysapp2.menu.page.PersonCenterPage;

public class NewPage extends BasePage {
	List<BasePage> menuPages;
	public NewPage(Context context) {
		super(context);
		
	}

	@Override
	public View initView(Context context) {
		
		//֡���֣�����
		TextView  tv=new TextView(context);
		tv.setText("这是信息");
		View v=View.inflate(context,R.layout.newspage, null);
		
		return v;
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		menuPages=new ArrayList<BasePage>();
		menuPages.add(new NewsItemPage(context));
		menuPages.add(new PersonCenterPage(context));
		menuPages.add(new ClearSessionPage(context));
		System.out.println("这是信息");
		//����ʱ��ʾ��2��view(NewsItemPage)
		changeView(0);
	}
	
	//���slidingmenu��ͬitem��v��Ӳ�ͬ��view
	public void changeView(int pos)
	{
		//�Ƴ�֡�������е�view
		((FrameLayout)getView()).removeAllViews();
		
		//��v��Ӳ�ͬ��basepager(��Ӧ��view)
		((FrameLayout)getView()).addView(menuPages.get(pos).getView());
		//��ʼ��ÿ���������
		menuPages.get(pos).initData();
        		
		
	}
}
