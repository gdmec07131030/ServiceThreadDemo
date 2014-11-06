package com.example.servicethreaddemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class serviceThread extends Service {
    private Runnable backgroundWork =new Runnable(){

		@Override
		public void run() {
			try{
			while(!Thread.interrupted()){
			double randomDouble =Math.random();
			MainActivity.UpdateGUI(randomDouble);
			Thread.sleep(1000);}}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			
		}};
	private Thread workThread;
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Toast.makeText(this, "Service has created!", 1000);
		workThread=new Thread(null,backgroundWork,"Workthread");
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Toast.makeText(this, "Service has stoped!", 1000);
		workThread.interrupt();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Toast.makeText(this, "Service has started!", 1000);
		if(!workThread.isAlive()){
			workThread.start();
		}
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

}
