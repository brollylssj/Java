package com.caseweek.example.todoapp;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.caseweek.example.todoapp.model.Category;
import com.caseweek.example.todoapp.model.DatabaseHelper;
import com.caseweek.example.todoapp.model.SpinnerCategoryArrayAdapter;
import com.caseweek.example.todoapp.model.Task;
import com.caseweek.example.todoapp.model.DatabaseHelper.Tables;
import com.commonsware.cwac.loaderex.acl.SQLiteCursorLoader;

public class TaskEditFragment extends Fragment implements LoaderCallbacks<Cursor>, OnClickListener {

	public static final String TAG = "TaskEditFragment";
	private static final String ITEM_ID = "ITEM_ID";

	private Cursor mCursor;

	private EditText mNameText;
	private Spinner mCategorySpinner;
	private TextView mDescriptionText;	
	private Button mSaveButton;

	private List<Category> mCategoryList = new ArrayList<Category>();
	private SpinnerCategoryArrayAdapter mCategoryAdapter;
	private String mCategoryCodeValue;

	public static TaskEditFragment newInstance() {
		TaskEditFragment f = new TaskEditFragment();
		Bundle args = new Bundle();
		args.putLong(ITEM_ID, -1);
		f.setArguments(args);
		return f;
	}

	public static TaskEditFragment newInstance(long id) {
		TaskEditFragment f = new TaskEditFragment();
		Bundle args = new Bundle();
		args.putLong(ITEM_ID, id);
		f.setArguments(args);
		return f;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// mSharedPrefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
		// mLastUpdate = mSharedPrefs.getString(ClmApplication.PREF_LAST_UPDATE, null);
		getLoaderManager().initLoader(0, null, this).forceLoad();
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		getLoaderManager().initLoader(0, null, this);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_task_edit, container, false);

		DatabaseHelper dbHelper = DatabaseHelper.getInstance(getActivity().getApplicationContext());

		mNameText = (EditText) v.findViewById(R.id.task_edit_name);
		mDescriptionText = (EditText) v.findViewById(R.id.task_edit_description);
		mCategorySpinner = (Spinner) v.findViewById(R.id.task_edit_category);
		mSaveButton = (Button) v.findViewById(R.id.task_edit_submit_button);
		mSaveButton.setOnClickListener(this);

		LayoutInflater layoutInflater = LayoutInflater.from(getActivity().getApplicationContext());
		mCategoryList = dbHelper.getCategories();
		mCategoryAdapter = new SpinnerCategoryArrayAdapter(getActivity().getApplicationContext(), R.layout.list_item_spinner, mCategoryList, layoutInflater, false, getString(R.string.category));

		mCategorySpinner.setAdapter(mCategoryAdapter);
		mCategorySpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
				mCategoryCodeValue = mCategoryList.get(position).getCode();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});		

		mCategorySpinner.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				mCategoryAdapter.setSelected(true);
				mCategoryAdapter.notifyDataSetChanged();
				return false;
			}
		});

		return v;
	}

	void updateViews() {
		mNameText.setText(mCursor.getString(mCursor.getColumnIndex(Task.NAME)));
		mDescriptionText.setText(mCursor.getString(mCursor.getColumnIndex(Task.DESC)));
		String categoryCode = mCursor.getString(mCursor.getColumnIndex(Task.CATEGORY_CODE));
		mCategoryAdapter.setSelected(categoryCode != null && !categoryCode.isEmpty());
		mCategoryAdapter.notifyDataSetChanged();
		if (categoryCode != null && !categoryCode.isEmpty() && mCategoryList != null && !mCategoryList.isEmpty()) {
			for (int i = 0; i < mCategoryList.size(); i++) {
				if (categoryCode.equals(mCategoryList.get(i).getCode())) {
					mCategorySpinner.setSelection(i);
					break;
				}
			}
		}		
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.task_edit_submit_button) {
			final long itemId = getArguments().getLong(ITEM_ID);
			Task task = new Task();
			if (itemId > 0) {
				task.setId(itemId);
			}
			task.setName(mNameText.getText().toString());
			task.setDescription(mDescriptionText.getText().toString());
			task.setCategoryCode(mCategoryCodeValue);
			DatabaseHelper.getInstance(getActivity()).insertOrUpdateTask(task);
			getFragmentManager().popBackStack();
		}
	}

	@Override
	public Loader<Cursor> onCreateLoader(int id, Bundle args) {
		final long itemId = getArguments().getLong(ITEM_ID);

		return new SQLiteCursorLoader(
				getActivity(),
				DatabaseHelper.getInstance(getActivity()).getReadableDatabase(),
				"SELECT * FROM " + Tables.TASKS + " WHERE " + Tables.TASKS +"._id = ?",
				new String[]{""+itemId});
	}

	@Override
	public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
		if (data.getCount() > 0) {
			data.moveToFirst();
			mCursor = data;
			updateViews();
		}
	}

	@Override
	public void onLoaderReset(Loader<Cursor> loader) {
		mCursor = null;
	}

}
