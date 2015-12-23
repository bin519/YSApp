package com.example.ysapp2.content.page;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.ysapp2.base.BasePage;

public class SettingPage extends BasePage {

	public SettingPage(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	@Override
	public View initView(Context context) {
		// TODO Auto-generated method stub
		TextView  tv=new TextView(context);
		tv.setText("这是个人中心");
		return tv;
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub

	}

}
