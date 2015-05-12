package com.caseweek.example.todoapp.model;

import android.content.ContentValues;
import android.database.Cursor;

public class Category extends CodeItem {

	public Category() {

	}

	public Category(Cursor c) {
		super (c);
	}

	public ContentValues getContentValues() {
		ContentValues cv = new ContentValues();
		cv.putAll(super.getContentValues());
		return cv;
	}
}
