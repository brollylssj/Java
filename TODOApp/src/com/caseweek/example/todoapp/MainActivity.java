package com.caseweek.example.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AbstractActivity implements TaskListFragment.Callbacks {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_singlepane_empty);
		initLayout("Home");
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.replace(R.id.container, TaskListFragment.newInstance(), TaskListFragment.TAG);
		transaction.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_add) {
			FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
			transaction.replace(R.id.container, TaskEditFragment.newInstance(), TaskListFragment.TAG).addToBackStack(null);
			transaction.commit();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onItemClick(long itemId) {
		Intent intent = new Intent(this, TaskActivity.class);
		intent.putExtra(TaskActivity.EXTRA_TASK_SCREEN, TaskActivity.TAKS_SCREEN_DETAILS);
		intent.putExtra(TaskActivity.EXTRA_ITEM_ID, itemId);
		startActivity(intent);
	}
}
