package com.example.ysapp2.base;

import android.content.Context;
import android.view.View;

public abstract class BasePage {
	View v;
	public Context context;
	
	public BasePage(Context context){
		v=initView(context);//initView赋值给v
		this.context=context;
	}
	
	//所有子类都实现该方法:初始化view
	abstract public View initView(Context context);
	
	//初始化数据：进入界面，initData()
	abstract public void initData();
	
	
	//获取view
	public View getView(){
		return v;
	}

}

