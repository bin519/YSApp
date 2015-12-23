package com.example.ysapp2;

import com.example.ysapp2.content.page.GovPage;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class DrugUseManageActivity extends Activity {
    Button addshpping;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drug_use_manage);
		addshpping = (Button) findViewById(R.id.add_shopping);
		addshpping.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
//				Intent it = new Intent(this,);
				
			}
		});
	}

	
}
