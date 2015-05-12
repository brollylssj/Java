package com.caseweek.example.todoapp.model;

import java.util.LinkedList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;



/**
 * CRUD operations for Clm types.
 * 
 * Every operation in this class is synchronous. That means: if we want insert/update or get some data from DB, we should do it in background thread (AsyncTask,
 * SQLiteCursorLoader).
 * 
 */
public class DatabaseHelper extends SQLiteOpenHelper {

	final String TAG = "DatabaseHelper";

	private Context mContext;

	// IMPORTANT: when application is released, everytime we want to change out database schema, we must
	// increment this value. More over, in onUpgrade method we have to handle upgrading database from older version to new one.
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "database.db";

	private static DatabaseHelper mInstance = null;

	public interface Tables {
		String TASKS = "task";
		String CATEGORIES = "categories";
	}

	private DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		mContext = context;	
	}

	public static DatabaseHelper getInstance(Context ctx) {
		if (mInstance == null) {
			mInstance = new DatabaseHelper(ctx.getApplicationContext());
		}
		return mInstance;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// @formatter:off
		db.execSQL("CREATE TABLE " + Tables.TASKS + " ("
				+ BaseColumns._ID	+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ Task.NAME	+ " TEXT, "
				+ Task.DESC	+ " TEXT, "
				+ Task.CATEGORY_CODE + " TEXT)");

		db.execSQL("CREATE TABLE " + Tables.CATEGORIES + " ("
				+ BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ Category.CODE + " TEXT, "
				+ Category.NAME + " TEXT)");
		
		db.execSQL("INSERT INTO " + Tables.CATEGORIES + " VALUES(1, 'dom', 'Dom');");
		db.execSQL("INSERT INTO " + Tables.CATEGORIES + " VALUES(2, 'praca', 'Praca');");
		db.execSQL("INSERT INTO " + Tables.CATEGORIES + " VALUES(3, 'uczelnia', 'Uczelnia');");
		// @formatter:on
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}

	public boolean dbExists() {
		java.io.File dbFile = mContext.getDatabasePath(DATABASE_NAME);
		return dbFile.exists();
	}

	// TASK
	// -----------------------------------------------------------------------------------------------------

	public void insertOrUpdateTask(Task item) {
		Task oldItem = getTask(item.getId());
		if (oldItem == null) {
			getWritableDatabase().insert(Tables.TASKS, null, item.getContentValues());
		}
		else {			
			updateTask(item);
		}
	}

	public void updateTask(Task item) {		
		getWritableDatabase().update(Tables.TASKS, item.getContentValues(), BaseColumns._ID + " = ?", new String[] { ""+item.getId() });
	}

	public Task getTask(long id) {
		Cursor c = getReadableDatabase().query(Tables.TASKS, null, BaseColumns._ID + " = ?", new String[] { ""+id }, null, null, null);
		c.moveToFirst();
		if (c.getCount() == 0) {
			c.close();
			return null;
		}
		Task item = new Task(c);
		c.close();
		return item;
	}
	
	public List<Category> getCategories() {
		Cursor c = getReadableDatabase().query(Tables.CATEGORIES, null, null, new String[] {}, null, null, null);
		c.moveToFirst();		
		if (c.getCount() == 0) {
			c.close();
			return null;
		}
		List<Category> items = new LinkedList<Category>();
		while (!c.isAfterLast()) {
			items.add(new Category(c));
			c.moveToNext();
		}
		c.close();
		return items;
	}
	
	public List<Category> getCategoriesAsMap() {
		Cursor c = getReadableDatabase().query(Tables.CATEGORIES, null, null, new String[] {}, null, null, null);
		c.moveToFirst();		
		if (c.getCount() == 0) {
			c.close();
			return null;
		}
		List<Category> items = new LinkedList<Category>();
		while (!c.isAfterLast()) {
			items.add(new Category(c));
			c.moveToNext();
		}
		c.close();
		return items;
	}
}

