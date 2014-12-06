package com.jialin.chat;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FunctionAdapter extends BaseAdapter {
	private List<Option> data;

	private LayoutInflater inflater;

	private int size = 0;

	public FunctionAdapter(Context context, List<Option> list) {
		this.inflater = LayoutInflater.from(context);
		this.data = list;
		this.size = list.size();
	}

	@Override
	public int getCount() {
		return this.size;
	}

	@Override
	public Object getItem(int position) {
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Option option = data.get(position);
		ViewHolder viewHolder = null;
		if (convertView == null) {
			viewHolder = new ViewHolder();
			convertView = inflater.inflate(R.layout.function_item, null);
			viewHolder.iconImageView 	= (ImageView) convertView.findViewById(R.id.iconImageView);
			viewHolder.nameTextView 	= (TextView) convertView.findViewById(R.id.nameTextView);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.iconImageView.setImageDrawable(option.getIconDrawable());
		viewHolder.nameTextView.setText(option.getName());
		return convertView;
	}

	class ViewHolder {

		public ImageView 	iconImageView;
		public TextView 	nameTextView;
	}
}