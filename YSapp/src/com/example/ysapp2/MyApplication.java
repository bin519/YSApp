package com.example.ysapp2;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application{
      private static Context context;

	@Override
	public void onCreate() {
		super.onCreate();
		context = getApplicationContext();
	}
    public static Context getContextObject(){
    	return context;  
    }
     
}
