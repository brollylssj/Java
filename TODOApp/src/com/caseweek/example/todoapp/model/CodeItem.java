package com.caseweek.example.todoapp.model;

import android.content.ContentValues;
import android.database.Cursor;

public class CodeItem {

	public static String CODE = "code";
	public static String NAME = "name";

	private String code;
	private String name;

	public CodeItem() {
	}

	public CodeItem(Cursor c) {
		code = c.getString(c.getColumnIndex(CODE));
		name = c.getString(c.getColumnIndex(NAME));
	}

	public ContentValues getContentValues() {
		ContentValues cv = new ContentValues();
		cv.put(CODE, code);
		cv.put(NAME, name);
		return cv;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
