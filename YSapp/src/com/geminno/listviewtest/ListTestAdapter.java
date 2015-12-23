package com.geminno.listviewtest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.example.ysapp2.R;
import com.geminno.entity.Drug;

public class ListTestAdapter extends BaseAdapter {

	private static final String TAG = ListTestAdapter.class.getSimpleName();

	private Context mContext;
	private List<Drug> mDrugList;
	ImageLoader mImageLoader;

	public ListTestAdapter(Context context, List<Drug> animeList) {
		mContext = context;
		mDrugList = animeList;
		mImageLoader = new ImageLoader(TestApplication.getRequeue(),
				new BitmapCache());

	}

	@Override
	public int getCount() {

		if (null == mDrugList) {
			return 0;
		}

		return mDrugList.size();
	}

	@Override
	public Object getItem(int position) {
		return mDrugList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	// viewholder 实行view的重复使??
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		System.out.println("执行了getView()方法");
		ViewHolder viewHolder = null;

		if (null == convertView) {

			Log.d(TAG, "" + position);

			// LayoutInflater inflater = LayoutInflater.from(mContext);
			// convertView = inflater.inflate(R.layout.stu_list_item, null);
			viewHolder = new ViewHolder();
			convertView = View.inflate(mContext, R.layout.pay_car_list, null);
			viewHolder.chkDrug = (CheckBox) convertView
					.findViewById(R.id.chk_drug);
			viewHolder.ivPayCar = (ImageView) convertView
					.findViewById(R.id.paycar_image);
			viewHolder.nameText = (TextView) convertView
					.findViewById(R.id.tv_drug_name);
			viewHolder.descText = (TextView) convertView
					.findViewById(R.id.tv_drug_desc);
			viewHolder.subBtn = (Button) convertView.findViewById(R.id.btn_sub);
			viewHolder.addBtn = (Button) convertView.findViewById(R.id.btn_add);
			viewHolder.countText = (EditText) convertView
					.findViewById(R.id.tv_count);

			// 根据学生类的设置姓名属??理解
			convertView.setTag(viewHolder);
		} else {
			// int ->long不需??long->int???? 小类型想大类型转换自动转换??大类型向小类型转换，????强转
			// object -> viewholder
			viewHolder = (ViewHolder) convertView.getTag();
		}

		viewHolder.nameText.setText(mDrugList.get(position).getName());
		viewHolder.descText.setText(mDrugList.get(position).getPrice()+"元");
		ImageListener listener = ImageLoader.getImageListener(
				viewHolder.ivPayCar, R.drawable.ic_launcher,
				R.drawable.ic_launcher);

		viewHolder.addBtn.setTag(viewHolder);
		viewHolder.subBtn.setTag(viewHolder);

		// mImageLoader.get(ConstantData.SERVER_URL +
		// mDrugList.get(position).getImage(), listener, 100, 100);

		viewHolder.addBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				String numString = ((ViewHolder) v.getTag()).countText
						.getText().toString();
				int count = Integer.parseInt(numString) + 1;
				((ViewHolder) v.getTag()).countText.setText(count + "");
			}
		});
		viewHolder.subBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				String numString = ((ViewHolder) v.getTag()).countText
						.getText().toString();
				int count = Integer.parseInt(numString) - 1;
				if (count > -1) {
					((ViewHolder) v.getTag()).countText.setText(count + "");
				}
			}
		});
		viewHolder.chkDrug.setTag(position + "");
		if (mDrugList.get(position).isChecked == 1) {
			viewHolder.chkDrug.setChecked(true);
		} else {
			viewHolder.chkDrug.setChecked(false);
		}
		
		viewHolder.chkDrug
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						int position = Integer.parseInt(buttonView.getTag()
								.toString());
						if (isChecked) {
							Log.i(TAG, "Checked position=" + position);
							mDrugList.get(position).isChecked = 1;
						} else {
							Log.i(TAG, "Checked position=" + position);
							mDrugList.get(position).isChecked = 0;
						}
					}
				});
		return convertView;

	}

	public class ViewHolder {
		CheckBox chkDrug;
		ImageView ivPayCar;
		TextView nameText;
		TextView descText;
		Button addBtn;
		Button subBtn;
		EditText countText;

	}

}
