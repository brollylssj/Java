package com.caseweek.example.todoapp;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.caseweek.example.todoapp.model.Category;
import com.caseweek.example.todoapp.model.DatabaseHelper;
import com.caseweek.example.todoapp.model.Task;
import com.caseweek.example.todoapp.model.DatabaseHelper.Tables;
import com.commonsware.cwac.loaderex.acl.SQLiteCursorLoader;


public class TaskDetailsFragment extends Fragment implements LoaderCallbacks<Cursor> {

	public static final String TAG = "TaskDetailsFragment";

	private static final String ARG_ITEM_ID = "ARG_ITEM_ID";
	private Cursor mCursor;
	private TextView mNameText;
	private TextView mCategoryText;
	private TextView mDescriptionText;

	public static TaskDetailsFragment newInstance(long itemId) {
		TaskDetailsFragment f = new TaskDetailsFragment();
		Bundle args = new Bundle();
		args.putLong(ARG_ITEM_ID, itemId);
		f.setArguments(args);
		return f;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		if (getArguments().getLong(ARG_ITEM_ID) > -1) {
			getLoaderManager().initLoader(0, null, this);
		}
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	public void setCursor(Cursor c) {
		mCursor = c;
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_task_details, container, false);
		mNameText = (TextView) v.findViewById(R.id.task_details_name);
		mCategoryText = (TextView) v.findViewById(R.id.task_details_category);
		mDescriptionText = (TextView) v.findViewById(R.id.task_details_description);
		return v;
	}

	@Override
	public void onResume() {
		super.onResume();
		getLoaderManager().restartLoader(0, null, this);
	}

	void updateViews() {
		if (mCursor == null) {
			return;
		}
		mNameText.setText(mCursor.getString(mCursor.getColumnIndex(Task.NAME)));
		mCategoryText.setText(mCursor.getString(mCursor.getColumnIndex("categoryName")));
		mDescriptionText.setText(mCursor.getString(mCursor.getColumnIndex(Task.DESC)));
	}

	@Override
	public Loader<Cursor> onCreateLoader(int id, Bundle args) {
		final long itemId = getArguments().getLong(ARG_ITEM_ID);
		return new SQLiteCursorLoader(getActivity().getApplicationContext(), DatabaseHelper.getInstance(getActivity())
				.getReadableDatabase(), "SELECT *, " +
						"(SELECT name FROM " + Tables.CATEGORIES + " WHERE " + Tables.TASKS + "." + Task.CATEGORY_CODE + " = " + Tables.CATEGORIES + "." + Category.CODE + ") as categoryName" +
						" FROM " + Tables.TASKS + " WHERE " + Tables.TASKS +"._id = ?", new String[]{""+itemId});
	}

	@Override
	public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
		if (data != null && data.getCount() > 0) {
			data.moveToFirst();
			mCursor = data;			
		}
		updateViews();
	}

	@Override
	public void onLoaderReset(Loader<Cursor> loader) {
		mCursor = null;
		updateViews();
	}
}