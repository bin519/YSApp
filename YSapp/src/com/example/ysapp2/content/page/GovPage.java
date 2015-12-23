package com.example.ysapp2.content.page;

import java.util.ArrayList;
import java.util.List;

import android.R.integer;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.example.ysapp2.R;
import com.example.ysapp2.base.BasePage;
import com.geminno.entity.Drug;
import com.geminno.listviewtest.ListTestAdapter;
import com.geminno.listviewtest.ListTestAdapter.ViewHolder;

public class GovPage extends BasePage implements OnClickListener{
	ImageView ivback;
	ImageView ivdelete;
	TextView tvshopping;
	ListView lv;
	CheckBox cb;
	TextView tvtotal;
	Button tvjiesuan;
	private List<Drug> mDrugList;
	Drug drug = null;
	ListTestAdapter lt;
    
	public GovPage(Context context) {
		super(context);

	}

	@Override
	public View initView(Context context) {
		TextView tv = new TextView(context);
		tv.setText("这是购物车");
		View v = View.inflate(context, R.layout.activity_par_car, null);
		ivback = (ImageView) v.findViewById(R.id.iv_back);
		ivdelete = (ImageView) v.findViewById(R.id.iv_delete);
		tvshopping = (TextView) v.findViewById(R.id.tv_shopping);
		lv = (ListView) v.findViewById(R.id.lv_shopping);
		cb = (CheckBox) v.findViewById(R.id.check);
		tvtotal = (TextView) v.findViewById(R.id.total);
		tvjiesuan = (Button) v.findViewById(R.id.jiesuan_button);
		mDrugList = new ArrayList<Drug>();
		ivdelete.setOnClickListener(this);
		ivback.setOnClickListener(this);
		tvjiesuan.setOnClickListener(this);
		
		 lv.setOnItemClickListener(new OnItemClickListener() {
		
		 @Override
		 public void onItemClick(AdapterView<?> parent, View v, int position,
		 long id) {
		   CheckBox cx = (CheckBox) v.findViewById(R.id.chk_drug);
		   EditText et = (EditText) v.findViewById(R.id.tv_count);
		   if(cx.isChecked()){
			   tvtotal.setText(et.getText().toString());
			   System.out.println(et.getText().toString());
		   }
		   
		 }
		 });
		
		
		cb.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if (isChecked) {
					for (Drug d : mDrugList) {
						d.isChecked = 1;
					}	
				} else {
					System.out.println("没有选择");
					for (Drug d : mDrugList) {
						d.isChecked = 0;
					} 
				}
				if (null != lt) {
					// 刷新ListView的显示，即显示的View，getView方法重新执行
					lt.notifyDataSetChanged();
				}
			}
		});	
	
		return v;

	}

	@Override
	public void initData() {
		
		for (int i = 0; i < 10; i++) {
			drug = new Drug();
			mDrugList.add(drug);
		}
		
		for (int i=0;i<mDrugList.size();i++) {
			mDrugList.get(i).setName("绣花裙"+i);
			mDrugList.get(i).setPrice(10.5);
			mDrugList.get(i).setCount(1);
		}
		
		lt = new ListTestAdapter(context, mDrugList);
		lv.setAdapter(lt);
		
		

	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.iv_back:
			//Intent it = new Intent(context, DrugUseManageActivity.class);
			//context.startActivity(it);
			break;
		case R.id.jiesuan_button:
//			List<EditText> ll = new ArrayList<EditText>();
//			EditText et=null;
//			for(int i=0;i<lv.getCount();i++){
//				et = (EditText)lv.getChildAt(i).findViewById(R.id.tv_count);
//				et.setText("123");
//				ll.add(et);
//			}
//			for(EditText e:ll){
//				System.out.println(e.getText().toString());
//			}
			List<Double> ls = new ArrayList<Double>();
			 for(int i=0;i<mDrugList.size();i++){
	            	if(mDrugList.get(i).isChecked==1){
						double price = mDrugList.get(i).getPrice() * mDrugList.get(i).getCount();
						ls.add(price);
					}
	            }
			    double sumPrice = 0;
	            for(double s:ls){
	            	sumPrice = sumPrice+s;
	            }
	            tvtotal.setText("合计:￥     "+sumPrice+"元");
			break;
		case R.id.iv_delete:
			List<Integer> is = new ArrayList<Integer>();
			for(int i=0;i<mDrugList.size();i++){
				if(mDrugList.get(i).isChecked==1){
					is.add(new Integer(i));
				}
			}
				for(int j=is.size()-1;j>=0;j--){
					int index = is.get(j).intValue();
					mDrugList.remove(index);
					
				}
				lt.notifyDataSetChanged();
				break;
			}
        
//				mDrugList.remove(); int y=is.size()-1;y>=0;y--
				
				
			
			
	

	}

	

}
