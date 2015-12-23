package com.example.ysapp2;


import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Window;

public class MainActivity extends SlidingActivity {
	@SuppressLint("NewApi")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//去标题：放在setContentView之前
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		// configure the SlidingMenu
				//SlidingMenu menu = new SlidingMenu(this);
		//设置slidingmenu的布局文件
		       setBehindContentView(R.layout.menu_left);  
				SlidingMenu menu = getSlidingMenu();  
				menu.setMode(SlidingMenu.LEFT);//放在zuobi
				// 设置触摸屏幕的模式
				menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);//TOUCHMODE_MARGIN：只有在边缘
				menu.setShadowWidthRes(R.dimen.shadow_width);//设置阴影图片的宽度  
				menu.setShadowDrawable(R.drawable.shadow);//设置阴影图片  

				// 设置滑动菜单视图的宽度
				menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);//拖出来之后，留出来的距离
				// 设置渐入渐出效果的值
				menu.setFadeDegree(0.35f);
				/**
				 * SLIDING_WINDOW will include the Title/ActionBar in the content
				 * section of the SlidingMenu, while SLIDING_CONTENT does not.
				 */
				//把滑动菜单添加进所有的Activity中，可选值SLIDING_CONTENT ， SLIDING_WINDOW
				//menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
				//为侧滑菜单设置布局
				//menu.setMenu(R.layout.menu_left);
				
				//替换帧布局
				getFragmentManager().beginTransaction().replace(R.id.content_frame,new ContentFragmentActivity(),"content").commit();
				getFragmentManager().beginTransaction().replace(R.id.menu_frame, new MenuFragmentActivity(),"menu").commit();
				
				
	}

	


	
}