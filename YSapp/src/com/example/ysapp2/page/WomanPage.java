package com.example.ysapp2.page;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.ysapp2.base.BasePage;

public class WomanPage extends BasePage {

	public WomanPage(Context context) {
		super(context);
		
	}

	@Override
	public View initView(Context context) {
		
		TextView tv=new TextView(context);
		tv.setText("”√“©÷∏ƒœ");
		return  tv;
	}

	@Override
	public void initData() {
		

	}

}
