package com.caseweek.example.todoapp.model;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.caseweek.example.todoapp.R;

public class SpinnerCategoryArrayAdapter extends ArrayAdapter<Category> {

	protected LayoutInflater layoutInflater;
	private boolean selected;
	private String emptyText;

	static class DictionaryViewHolder {
		TextView itemValueText;
	}

	public SpinnerCategoryArrayAdapter(Context context, int textViewResourceId, List<Category> objects, LayoutInflater mInflater, boolean selected, String emptyText) {
		super(context, textViewResourceId, objects);
		layoutInflater = mInflater;
		this.selected = selected;
		this.emptyText = emptyText;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		DictionaryViewHolder holder;
		if (convertView == null) {
			convertView = layoutInflater.inflate(R.layout.list_item_spinner, parent, false);
			holder = new DictionaryViewHolder();
			holder.itemValueText = (TextView) convertView.findViewById(R.id.spinner_item_value);
			convertView.setTag(holder);
		} else {
			holder = (DictionaryViewHolder) convertView.getTag();
		}
		Category dictionaryItem = getItem(position);
		holder.itemValueText.setText(dictionaryItem.getName());
		if (!selected) {
			holder.itemValueText.setText(emptyText);
		}
		return convertView;
	}

	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		DictionaryViewHolder holder;
		if (convertView == null) {
			convertView = layoutInflater.inflate(R.layout.list_item_spinner, parent, false);
			holder = new DictionaryViewHolder();
			holder.itemValueText = (TextView) convertView.findViewById(R.id.spinner_item_value);
			convertView.setTag(holder);
		} else {
			holder = (DictionaryViewHolder) convertView.getTag();
		}
		Category dictionaryItem = getItem(position);
		holder.itemValueText.setText(dictionaryItem.getName());
		return convertView;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

}
