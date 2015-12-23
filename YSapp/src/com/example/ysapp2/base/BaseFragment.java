package com.example.ysapp2.base;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {
	//����fragment��view
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			
			return initView(getActivity());
		}

		//activity������֮��
		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onActivityCreated(savedInstanceState);
			initData();
		}
		
		//�������඼ʵ�ָ÷���:��ʼ��view
			abstract public View initView(Context context);

			//��ʼ��(����)��ʾ���ݣ�������棬initData()
			abstract public void initData();
	}


