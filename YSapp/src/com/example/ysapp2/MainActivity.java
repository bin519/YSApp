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
		//ȥ���⣺����setContentView֮ǰ
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		// configure the SlidingMenu
				//SlidingMenu menu = new SlidingMenu(this);
		//����slidingmenu�Ĳ����ļ�
		       setBehindContentView(R.layout.menu_left);  
				SlidingMenu menu = getSlidingMenu();  
				menu.setMode(SlidingMenu.LEFT);//����zuobi
				// ���ô�����Ļ��ģʽ
				menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);//TOUCHMODE_MARGIN��ֻ���ڱ�Ե
				menu.setShadowWidthRes(R.dimen.shadow_width);//������ӰͼƬ�Ŀ��  
				menu.setShadowDrawable(R.drawable.shadow);//������ӰͼƬ  

				// ���û����˵���ͼ�Ŀ��
				menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);//�ϳ���֮���������ľ���
				// ���ý��뽥��Ч����ֵ
				menu.setFadeDegree(0.35f);
				/**
				 * SLIDING_WINDOW will include the Title/ActionBar in the content
				 * section of the SlidingMenu, while SLIDING_CONTENT does not.
				 */
				//�ѻ����˵���ӽ����е�Activity�У���ѡֵSLIDING_CONTENT �� SLIDING_WINDOW
				//menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
				//Ϊ�໬�˵����ò���
				//menu.setMenu(R.layout.menu_left);
				
				//�滻֡����
				getFragmentManager().beginTransaction().replace(R.id.content_frame,new ContentFragmentActivity(),"content").commit();
				getFragmentManager().beginTransaction().replace(R.id.menu_frame, new MenuFragmentActivity(),"menu").commit();
				
				
	}

	


	
}