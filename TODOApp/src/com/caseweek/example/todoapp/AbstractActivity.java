package com.caseweek.example.todoapp;

import org.xmlpull.v1.XmlPullParser;

import android.content.Context;
import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class AbstractActivity extends ActionBarActivity implements OnItemClickListener {

	private DrawerLayout mDrawerLayout;
	protected FrameLayout mRootContainer;
	private ListView mDrawerLeftList;
	private NavigationAdapter mNavigationAdapterLeft;
	private ImageView mActionBarLeftButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void initLayout(String activityTitle) {
		mNavigationAdapterLeft = new NavigationAdapter(this, R.menu.drawer_left);
		mDrawerLeftList = (ListView) findViewById(R.id.navigation_drawer);
		mDrawerLeftList.setAdapter(mNavigationAdapterLeft);
		mDrawerLeftList.setOnItemClickListener(this);
		
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
		setSupportActionBar(toolbar);	
		((TextView) findViewById(R.id.actionbar_title)).setText(activityTitle);;
		mActionBarLeftButton = (ImageView) toolbar.findViewById(R.id.actionbar_button_left);
	}
		
	@Override
	public void setContentView(int layoutResID) {
		mDrawerLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_main, null);
		mRootContainer = (FrameLayout) mDrawerLayout.findViewById(R.id.root_container);
		getLayoutInflater().inflate(layoutResID, mRootContainer, true);
		super.setContentView(mDrawerLayout);
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		if (parent != null && parent.equals(mDrawerLeftList)) {
			onNavigationDrawerItemSelected(((MenuDrawerItem) parent.getAdapter().getItem(position)).id);
		}
	}
	
	public void onNavigationDrawerItemSelected(int id) {
		if (id == R.id.menu_1) {
			Intent intent = new Intent(this, MainActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
		}
		else if (id == R.id.menu_2) {
			Intent intent = new Intent(this, TaskActivity.class);
			intent.putExtra(TaskActivity.EXTRA_TASK_SCREEN, TaskActivity.TASK_SCREEN_FILTERS);
			startActivity(intent);
		}
		else if (id == R.id.menu_3) {
			//TODO
		}
		else if (id == R.id.menu_4) {
			startService(new Intent(getApplicationContext(), SyncService.class));
		}
	}
	
	public void toogleDrawer() {
		if (mDrawerLayout.isDrawerOpen(Gravity.END)) {
			mDrawerLayout.closeDrawer(Gravity.END);
		}
		if (mDrawerLayout.isDrawerOpen(Gravity.START)) {
			mDrawerLayout.closeDrawer(Gravity.START);
		}
		else {
			mDrawerLayout.openDrawer(Gravity.START);
		}
	}
	
	@Override
	public void onBackPressed() {
		if (mDrawerLayout != null && (mDrawerLayout.isDrawerOpen(Gravity.START) || mDrawerLayout.isDrawerOpen(Gravity.END))) {
			mDrawerLayout.closeDrawers();
		}
		else {
			super.onBackPressed();
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return super.onOptionsItemSelected(item);
	}

	public static class MenuDrawerItem {
		public int id;
		public int iconRes;
		public String label;
	}

	public class NavigationAdapter extends ArrayAdapter<MenuDrawerItem> {

		public NavigationAdapter(Context context, int menuRes) {
			super(context, 0);
			parseXml(menuRes);
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_menu_drawer, null);
			}
			ImageView icon = (ImageView) convertView.findViewById(R.id.row_icon);
			icon.setImageResource(getItem(position).iconRes);
			TextView title = (TextView) convertView.findViewById(R.id.row_title);
			title.setText(getItem(position).label);
			return convertView;
		}

		private void parseXml(int menu) {
			// use 0 id to indicate no menu (as specified in JavaDoc)
			if(menu == 0) return;
			try {
				XmlResourceParser xpp = getResources().getXml(menu);
				xpp.next();
				int eventType = xpp.getEventType();
				while(eventType != XmlPullParser.END_DOCUMENT) {
					if(eventType == XmlPullParser.START_TAG) {
						String elemName = xpp.getName();
						if(elemName.equals("item")) {
							String textId = xpp.getAttributeValue("http://schemas.android.com/apk/res/android", "title");
							String iconId = xpp.getAttributeValue("http://schemas.android.com/apk/res/android", "icon");
							String resId = xpp.getAttributeValue("http://schemas.android.com/apk/res/android", "id");
							MenuDrawerItem item = new MenuDrawerItem();
							item.id = Integer.valueOf(resId.replace("@", ""));
							item.iconRes = Integer.valueOf(iconId.replace("@", ""));
							item.label = resourceIdToString(textId);
							add(item);							
						}
					}
					eventType = xpp.next();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		private String resourceIdToString(String text){
			if (!text.contains("@")) {
				return text;
			}
			else {
				String id = text.replace("@", "");
				return getResources().getString(Integer.valueOf(id));

			}
		}
	}

}
