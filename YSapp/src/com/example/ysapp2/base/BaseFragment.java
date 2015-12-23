package com.example.ysapp2.base;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {
	//设置fragment的view
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			
			return initView(getActivity());
		}

		//activity创建完之后
		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onActivityCreated(savedInstanceState);
			initData();
		}
		
		//所有子类都实现该方法:初始化view
			abstract public View initView(Context context);

			//初始化(界面)显示数据：进入界面，initData()
			abstract public void initData();
	}


