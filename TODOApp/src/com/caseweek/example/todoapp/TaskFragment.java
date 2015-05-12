package com.caseweek.example.todoapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.common.view.SlidingTabLayout;
import com.viewpagerindicator.TitleProvider;

public class TaskFragment extends Fragment {

	public static final String TAG = "OfferFragment";

	private SlidingTabLayout mSlidingTabLayout;
	private ViewPager mViewPager;
	private TaskFragmentPagerAdapter mAdapter;
	private int mScreenFiltrType = -1;

	public static TaskFragment newInstance() {
		TaskFragment f = new TaskFragment();
		return f;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mAdapter = new TaskFragmentPagerAdapter(getFragmentManager());
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_task_slidingtab, container, false);
		return view;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		mViewPager = (ViewPager) view.findViewById(R.id.task_sliding_tabs_viewpager);
		mViewPager.setAdapter(mAdapter);
		mSlidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.task_sliding_tabs);
		mSlidingTabLayout.setDistributeEvenly(true);
		mSlidingTabLayout.setViewPager(mViewPager);
		if (mScreenFiltrType > -1) {
			mViewPager.setCurrentItem(mScreenFiltrType);
		}
		mSlidingTabLayout.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				super.onPageSelected(position);
			}
		});
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
}
