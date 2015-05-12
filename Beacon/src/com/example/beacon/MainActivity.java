package com.example.beacon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.R.color;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.comarch.cbeacon.BeaconManager;
import com.comarch.cbeacon.IBeacon;
import com.comarch.cbeacon.IRangeListener;
import com.comarch.cbeacon.ListenerNullException;
import com.comarch.cbeacon.Region;

public class MainActivity extends Activity {
	
	
	private BeaconManager mBeaconManager = new BeaconManager(this);
	private Region allregions;
	private ListView listview;
	private BeaconListAdapter mBeaconListAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		allregions = new Region(null);
		listview = (ListView)findViewById(R.id.listView1);
		
		mBeaconListAdapter = new BeaconListAdapter();
		listview.setAdapter(mBeaconListAdapter);
		
		
		
		mBeaconManager.initialize();
		mBeaconManager.registerRangingListener(new IRangeListener() {
		
		@Override
		public void rangeBeaconUpdateCallback(final List<IBeacon> beacons) {
			// TODO Auto-generated method stub
			
			runOnUiThread (new Runnable() {
				public void run() {
					Log.e("dsad", " ");
					if(beacons != null)
					{
						mBeaconListAdapter.setBeacons(beacons);
						mBeaconListAdapter.notifyDataSetChanged();
						checkDistance(beacons);
						
						
								
					}
					
				}
				
				private void send(IBeacon beacon)
				{
					
					BeaconData data = new BeaconData();
					data.setUid(beacon.getUuid().toString());
					data.setMajor(beacon.getMajor());
					data.setMinor(beacon.getMinor());
					
					WifiManager wifiManager = (WifiManager)MainActivity.this.getSystemService(Context.WIFI_SERVICE);
					WifiInfo wifiInfo = wifiManager.getConnectionInfo();
					data.setDeviceId(wifiInfo.getMacAddress());
					new ClientConnection(data).start();
				}

				private void checkDistance(List<IBeacon> beacons) {
					for (Iterator iterator = beacons.iterator(); iterator.hasNext();) {
						IBeacon iBeacon = (IBeacon) iterator.next();
						
						send(iBeacon);
						
						if(iBeacon.getDistance()<0.2)
						{
							if(iBeacon.getMinor() == 1788)
							{
							listview.setBackgroundColor(Color.RED);
							break;
							}
						
							else if(iBeacon.getMinor() == 850)
							{
								listview.setBackgroundColor(Color.BLUE);	
								break;
							}
							else if(iBeacon.getMinor() == 1784)
							{
								listview.setBackgroundColor(Color.GREEN);	
								break;
							}
							
							else 
							{
								listview.setBackgroundColor(Color.WHITE);
							}
						
						}else 
						{
							listview.setBackgroundColor(Color.WHITE);
						}
						
						
						
						
						
					}
					
				}
				

			});
			
			
			
			
		}
	});
		
			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	protected void onResume()
	{
		super.onResume();
		
		try {
			mBeaconManager.startRangingBeaconsInRegion(allregions);
		} catch ( ListenerNullException e) {
			// TODO: handle exception
			Log.e("sdad", "",e);
		}
	}
	
	@Override
	protected void onPause()
	{
		super.onPause();
		try {
			mBeaconManager.stopRangingBeaconsInRegion(allregions);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	private class BeaconListAdapter extends BaseAdapter{
		private ArrayList<IBeacon> mBeacon;
		private LayoutInflater mInflator;
		
		public BeaconListAdapter()
		{
			super();
			mBeacon =new ArrayList<IBeacon>();
			mInflator = MainActivity.this.getLayoutInflater();
		}
		@Override
		public int getCount()
		{
			return mBeacon.size();
		}
		
		@Override
		public Object getItem(int arg1) {
			// TODO Auto-generated method stub
			return mBeacon.get(arg1);
		}
		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}
		@Override
		public View getView(int i, View view, ViewGroup viewGroup) {
			// TODO Auto-generated method stub

			//ViewHolder nei poszukuje po drzewie a viewHolder juz haszuje widoki
			ViewHolder viewHolder;
			
			// czy widok jest pusty bo android bd szukal tyle widokow ile zmiesci a dopiero potem jak przewijamy poznawal kolejnie przeladowywal
			if(view == null)
			{
				view = mInflator.inflate(R.layout.list_item,null);
				
				viewHolder = new ViewHolder();
				viewHolder.deviceName = (TextView) view.findViewById(R.id.device_name);
				viewHolder.deviceAddress = (TextView) view.findViewById(R.id.device_address);
				viewHolder.deviceUuid = (TextView) view.findViewById(R.id.device_uuid);
				viewHolder.deviceExtra = (TextView) view.findViewById(R.id.device_extra);
				
				view.setTag(viewHolder);
				
				
			}
			else
			{
				viewHolder = (ViewHolder)view.getTag();
			}
			
			IBeacon cBeacon = mBeacon.get(i);
			viewHolder.deviceName.setText(cBeacon.getName());
			viewHolder.deviceAddress.setText(cBeacon.getAddress().trim());
			viewHolder.deviceUuid.setText(cBeacon.getUuid().toString().trim());
			viewHolder.deviceExtra.setText("Major: "+cBeacon.getMajor() + " Minor: " +cBeacon.getMinor() + " Distance: " + cBeacon.getDistance());
			
			
			return view;
		}
		
		public void clear()
		{
			mBeacon.clear();
		}
	
		public void setBeacons(List<IBeacon> beacons)
		{
			mBeacon.clear();
			mBeacon.addAll(beacons);
		}
		
		
		
		
	
	
	
}
	static class ViewHolder
	{
		TextView deviceName;
		TextView deviceAddress;
		TextView deviceUuid;
		TextView deviceExtra;
	}
	
	
	
	
	
	
}
