package com.geminno.activity;

import com.example.ysapp2.R;
import com.example.ysapp2.R.layout;
import com.example.ysapp2.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class DrugUseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drug_use);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.drug_use, menu);
		return true;
	}

}
