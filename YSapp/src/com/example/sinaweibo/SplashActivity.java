package com.example.sinaweibo;

import com.example.ysapp2.MainActivity;
import com.example.ysapp2.R;
import com.example.ysapp2.R.layout;
import com.example.ysapp2.R.menu;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.view.Menu;
import android.widget.TextView;

public class SplashActivity extends Activity {
	 private final int SPLASH_DISPLAY_LENGHT = 3000; //�ӳ�����  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);   
	        setContentView(R.layout.activity_splash);   
	        new Handler().postDelayed(new Runnable(){   
	    
	         @Override   
	         public void run() {   
	             Intent mainIntent = new Intent(SplashActivity.this,MainActivity.class);   
	             SplashActivity.this.startActivity(mainIntent);   
	                 SplashActivity.this.finish();   
	         }   
	              
	        }, SPLASH_DISPLAY_LENGHT);   
	    }   
	        
	}
	   
	


