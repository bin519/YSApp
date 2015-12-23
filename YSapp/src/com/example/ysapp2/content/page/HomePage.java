package com.example.ysapp2.content.page;





import android.content.Context;

import android.view.View;



import android.widget.TextView;
import com.example.ysapp2.base.BasePage;

public class HomePage extends BasePage  {
	
	
	public HomePage(Context context) {
		super(context);
		
	}
	@Override
	public View initView(Context context) {
		
		TextView  tv=new TextView(context);
		tv.setText("这是主页");
		
		return tv;
	}

	@Override
	public void initData() {
		
	}
	

}
