package com.example.ysapp2;

import com.example.sinaweibo.SplashActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DrugUseManageActivity extends Activity {
    Button bt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drug_use_manage);
		bt = (Button) findViewById(R.id.add_shopping);
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent it = new Intent(DrugUseManageActivity.this,MainActivity.class);
				DrugUseManageActivity.this.startActivity(it);
				System.out.println("µã»÷°´Å¥");
			}
		});
		
	}
    
}
