package com.caseweek.example.todoapp.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.provider.BaseColumns;

public class Task {
	
	public static String NAME = "name";
	public static String DESC = "description";
	public static String CATEGORY_CODE = "categoryCode";
	
	private long id = -1;
	private String name;
	private String description;
	private String categoryCode;

	public Task() {

	}

	public Task(Cursor c) {
		id = c.getLong(c.getColumnIndex(BaseColumns._ID));
		name = c.getString(c.getColumnIndex(NAME));
		description = c.getString(c.getColumnIndex(DESC));
		categoryCode = c.getString(c.getColumnIndex(CATEGORY_CODE));
	}

	public ContentValues getContentValues() {
		ContentValues cv = new ContentValues();
		cv.put(NAME, name);
		cv.put(DESC, description);
		cv.put(CATEGORY_CODE, categoryCode);
		return cv;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
}
