package com.caseweek.example.todoapp;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.caseweek.example.todoapp.model.Category;
import com.caseweek.example.todoapp.model.DatabaseHelper;
import com.caseweek.example.todoapp.model.Task;
import com.caseweek.example.todoapp.model.DatabaseHelper.Tables;
import com.commonsware.cwac.loaderex.acl.SQLiteCursorLoader;

/**
 * Fragment used for displaying tasks in list form.
 */
public class TaskListFragment extends ListFragment implements LoaderCallbacks<Cursor> {

	public static final String TAG = "TaskListFragment";

	private static final String FILTER = "filter";
	public static final int FILTER_1 = 0;
	public static final int FILTER_2 = 1;

	private Callbacks mCallbacks;
	private SimpleCursorAdapter mAdapter;

	private LayoutInflater mInflater;

	final static String[] FROM = new String[] { Task.NAME };
	final static int[] TO = new int[] { R.id.task_name };

	public interface Callbacks {
		public void onItemClick(long itemId);
	}

	public static TaskListFragment newInstance() {
		TaskListFragment f = new TaskListFragment();
		return f;
	}

	public static TaskListFragment newInstance(int filter) {
		TaskListFragment f = new TaskListFragment();
		Bundle args = new Bundle();
		args.putInt(FILTER, filter);
		f.setArguments(args);
		return f;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mInflater = LayoutInflater.from(getActivity().getApplicationContext());
		mAdapter = new TaskListAdapter(getActivity().getApplicationContext(), R.layout.list_item_task, null, FROM, TO, 0);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_task_list, container, false);
		return view;
	}

	public void updateViews() {
		getLoaderManager().restartLoader(0, null, this);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			mCallbacks = (Callbacks) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString() + " must implement TaskListFragment.Callbacks");
		}
	}

	static class TaskViewHolder {
		TextView mName;
		TextView mCategory;
	}

	class TaskListAdapter extends SimpleCursorAdapter {

		public TaskListAdapter(Context arg0, int arg1, Cursor arg2, String[] arg3, int[] arg4, int arg5) {
			super(arg0, arg1, arg2, arg3, arg4, arg5);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			TaskViewHolder holder;
			if (convertView == null) {
				convertView = mInflater.inflate(R.layout.list_item_task, parent, false);
				holder = new TaskViewHolder();
				holder.mName = (TextView) convertView.findViewById(R.id.task_name);
				holder.mCategory = (TextView) convertView.findViewById(R.id.task_category);
				convertView.setTag(holder);
			} else {
				holder = (TaskViewHolder) convertView.getTag();
			}
			Cursor c = this.mCursor;
			c.moveToPosition(position);
			holder.mName.setText(c.getString(c.getColumnIndex(Task.NAME)));
			holder.mCategory.setText(c.getString(c.getColumnIndex("catName")));
			return convertView;
		}

	}

	@Override
	public void onResume() {
		super.onResume();
		getLoaderManager().restartLoader(0, null, this);

	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		getListView().setClickable(true);
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Cursor c = (Cursor) mAdapter.getItem(position);
		if (c.getCount() > 0) {
			long itemId = c.getLong(c.getColumnIndex(BaseColumns._ID));
			mCallbacks.onItemClick(itemId);
		}
	}

	@Override
	public Loader<Cursor> onCreateLoader(int id, Bundle args) {
		// String[] selectionArgs = null;
		// final String[] PROJECTION = new String[] { BaseColumns._ID, Task.NAME
		// };
		// String WHERE = "";
		// return new SQLiteCursorLoader(getActivity().getApplicationContext(),
		// DatabaseHelper.getInstance(getActivity()).getReadableDatabase(),
		// SQLiteQueryBuilder.buildQueryString(true,
		// DatabaseHelper.Tables.TASKS, PROJECTION, WHERE, null, null,
		// Task.NAME, null), selectionArgs);
		return new SQLiteCursorLoader(getActivity().getApplicationContext(), DatabaseHelper.getInstance(getActivity()).getReadableDatabase(), "SELECT *, " + "(SELECT name FROM " + Tables.CATEGORIES + " WHERE " + Tables.TASKS + "." + Task.CATEGORY_CODE + " = " + Tables.CATEGORIES + "." + Category.CODE + ") as catName" + " FROM " + Tables.TASKS, null);
	}

	@Override
	public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
		mAdapter.swapCursor(data);
		setListAdapter(mAdapter);
	}

	@Override
	public void onLoaderReset(Loader<Cursor> loader) {
		mAdapter.swapCursor(null);
	}
}
