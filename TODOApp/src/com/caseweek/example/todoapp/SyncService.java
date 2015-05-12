package com.caseweek.example.todoapp;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;

public class SyncService extends IntentService {

	private int i;
	private Handler handler = new Handler();

	public SyncService() {
		super("Service");
	}

	@Override
	protected void onHandleIntent(Intent intent) {

		while (i < 1) {
			try {
				Thread.sleep(5000);
				//DatabaseHelper.getInstance(getApplicationContext());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			handler.post(new Runnable() {
				public void run() {
					Toast.makeText(getApplicationContext(), "Tutaj twoj Service!", Toast.LENGTH_SHORT).show();
				}
			});
			i++;
		}
	}

}