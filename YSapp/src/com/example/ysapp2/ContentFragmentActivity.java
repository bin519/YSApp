package com.example.ysapp2;


import java.util.ArrayList;
import java.util.List;


import com.example.ysapp2.base.BaseFragment;
import com.example.ysapp2.base.BasePage;

import com.example.ysapp2.content.page.GovPage;
import com.example.ysapp2.content.page.HomePage;
import com.example.ysapp2.content.page.NewPage;
import com.example.ysapp2.content.page.SettingPage;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class ContentFragmentActivity extends BaseFragment implements OnCheckedChangeListener {

	ViewPager vp; 
	List<BasePage> contentpagers;//vp中view来源于basepage
	RadioGroup rg;
	
	
	
	
//	@Override
//	public View onCreateView(LayoutInflater inflater, ViewGroup container,
//			Bundle savedInstanceState) {
//		// TODO Auto-generated method stub
//		
//		return initView(getActivity());
//	}
	
	
	public List<BasePage> getContentpagers() {
		return contentpagers;
	}

	

	@Override
	public View initView(Context context) {
		// TODO Auto-generated method stub
		View v=View.inflate(context, R.layout.fragment_content, null);
		vp=(ViewPager) v.findViewById(R.id.content);
		rg=(RadioGroup) v.findViewById(R.id.group);
		return v;
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		
		contentpagers=new ArrayList<BasePage>();
		//viewpager中显示的view来自于以下page
		contentpagers.add(new HomePage(getActivity()));
		contentpagers.add(new NewPage(getActivity()));
		contentpagers.add(new GovPage(getActivity()));
		contentpagers.add(new SettingPage(getActivity()));
		//给viewpager设置数据源
		vp.setAdapter(new MyPageAdapter());
		//vp改变后,radiobutton选中项跟着改变
		vp.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int pos) {
				// TODO Auto-generated method stub
				//radiobutton跟着改变
				System.out.println("vp调用onPageSelected");
				((RadioButton)rg.getChildAt(pos)).setChecked(true);
				
				//判断当前选中的是否是第一项，如果是：全屏模式；如果不是，到边缘显示
				if(pos==0){
					((MainActivity)getActivity()).getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
					//menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN)
				}else{
					((MainActivity)getActivity()).getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
				}
				//调用不同子界面的initdata方法
				contentpagers.get(pos).initData();
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		//rg的某一个radiobutton被选中：vp显示的view跟着改变
		rg.setOnCheckedChangeListener(this);
		
		
	}

	/*
	 * ViewPager:预加载（viewpager）
	 * 1个界面显示：实例化1,2；
	 * 2个界面显示：实例化3个；
	 * 3个界面显示：实例化第4个，销毁第一个；
	 */
	
	class MyPageAdapter extends PagerAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return contentpagers.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0==arg1;
		}

		//销毁item
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			// TODO Auto-generated method stub
			container.removeView(contentpagers.get(position).getView());
			
		}

		//实例化item
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// TODO Auto-generated method stub
			container.addView(contentpagers.get(position).getView());
			return contentpagers.get(position).getView();
		}	
	}

	//某一个radiobutton被选中事件
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		//根据checkedId，判断哪一项被选中
		System.out.println("radiobutton调用onCheckedChanged");
		int item=-1;
		switch( checkedId){
		case R.id.home:
			item=0;
			break;
		case R.id.newscenter:
			item=1;
			break;
		case R.id.govaffairs:
			item=2;
			break;
		case R.id.settings:
			item=3;
			break;
		}
		//改变vp显示项
		vp.setCurrentItem(item);
	}

}