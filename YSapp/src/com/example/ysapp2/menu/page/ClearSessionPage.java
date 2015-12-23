package com.example.ysapp2.menu.page;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.ysapp2.base.BasePage;

public class ClearSessionPage extends BasePage {

	public ClearSessionPage(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}


	@Override
	public View initView(Context context) {
		// TODO Auto-generated method stub
		TextView tv=new TextView(context);
		tv.setText("Çå³ý»º´æ");
		return tv;
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub

	}

}
