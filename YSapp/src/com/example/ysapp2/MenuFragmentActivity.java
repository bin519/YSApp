package com.example.ysapp2;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ysapp2.base.BaseFragment;
import com.example.ysapp2.content.page.NewPage;



public class MenuFragmentActivity extends BaseFragment {

	ListView lv;
	ArrayList<String> titles;
	@Override
	public View initView(Context context) {
		// TODO Auto-generated method stub
		View v=View.inflate(context, R.layout.fragment_menu, null);
		 lv=(ListView) v.findViewById(R.id.lv_menu);
		
		return v;
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		titles=new ArrayList<String>();
		titles.add("新闻");
		titles.add("个人中心");
		titles.add("清除缓存");
		
        ArrayAdapter adapter=new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,titles);
		 
		 lv.setAdapter(adapter);
		 //点击item，切换新闻界面内容
		 lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				//newspage->contentfragment(contentpagers:1)->MainActivity
			
				ContentFragmentActivity contentFragment = (ContentFragmentActivity) ((MainActivity)getActivity()).getFragmentManager().findFragmentByTag("content");
				contentFragment.vp.setCurrentItem(1);//切换到新闻的view
			   ((NewPage)contentFragment.getContentpagers().get(1)).changeView(position);
			}
		});
		 
		 
	}

}
