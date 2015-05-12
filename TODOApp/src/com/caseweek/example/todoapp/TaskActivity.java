package com.caseweek.example.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;

import com.viewpagerindicator.TitleProvider;

public class TaskActivity extends AbstractActivity implements TaskListFragment.Callbacks {

	public static final String EXTRA_TASK_SCREEN = "EXTRA_TASK_SCREEN";	
	public static final String EXTRA_ITEM_ID = "EXTRA_ITEM_ID";

	public static final int TAKS_SCREEN_DETAILS = 1;
	public static final int TASK_SCREEN_FILTERS = 2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle extras = getIntent().getExtras();
		int screenType = extras.getInt(EXTRA_TASK_SCREEN);
		if (screenType == TAKS_SCREEN_DETAILS) {
			setContentView(R.layout.activity_singlepane_empty);
			long itemId = extras.getLong(EXTRA_ITEM_ID);
			FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
			transaction.replace(R.id.container, TaskDetailsFragment.newInstance(itemId), TaskDetailsFragment.TAG);
			transaction.commit();
		}
		else if (screenType == TASK_SCREEN_FILTERS) {
			setContentView(R.layout.activity_singlepane_empty);
			FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
			transaction.replace(R.id.container, TaskFragment.newInstance(), TaskFragment.TAG);
			transaction.commit();			
		}
		initLayout(getString(R.string.title_menu_2));
	}

	class TaskFragmentPagerAdapter extends FragmentPagerAdapter implements TitleProvider {

		public Fragment mCurrentFragment;

		final String[] titles = {getString(R.string.task_tab_1), getString(R.string.task_tab_2)};
		final int[] filters = {TaskListFragment.FILTER_1, TaskListFragment.FILTER_2};

		public TaskFragmentPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			return TaskListFragment.newInstance(filters[position]);
		}

		@Override
		public int getCount() {
			return titles.length;
		}

		@Override
		public String getTitle(int position) {
			return titles[position];
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return titles[position];
		}

		@Override
		public void setPrimaryItem(ViewGroup container, int position, Object object) {
			if (mCurrentFragment != object) {
				mCurrentFragment = (Fragment) object;
			}
			super.setPrimaryItem(container, position, object);
		}
	}

	@Override
	public void onItemClick(long itemId) {
		Intent intent = new Intent(this, TaskActivity.class);
		intent.putExtra(TaskActivity.EXTRA_TASK_SCREEN, TaskActivity.TAKS_SCREEN_DETAILS);
		intent.putExtra(TaskActivity.EXTRA_ITEM_ID, itemId);
		startActivity(intent);		
	}
}
