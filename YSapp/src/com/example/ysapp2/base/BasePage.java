package com.example.ysapp2.base;

import android.content.Context;
import android.view.View;

public abstract class BasePage {
	View v;
	public Context context;
	
	public BasePage(Context context){
		v=initView(context);//initView��ֵ��v
		this.context=context;
	}
	
	//�������඼ʵ�ָ÷���:��ʼ��view
	abstract public View initView(Context context);
	
	//��ʼ�����ݣ�������棬initData()
	abstract public void initData();
	
	
	//��ȡview
	public View getView(){
		return v;
	}

}

