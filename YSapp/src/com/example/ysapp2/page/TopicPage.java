package com.example.ysapp2.page;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.ysapp2.base.BasePage;

public class TopicPage extends BasePage {

	public TopicPage(Context context) {
		super(context);
		
	}

	@Override
	public View initView(Context context) {
		
		TextView tv=new TextView(context);
		tv.setText("ÑøÉú");
		return  tv;
	}

	@Override
	public void initData() {
		

	}

}
