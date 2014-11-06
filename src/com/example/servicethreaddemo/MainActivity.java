package com.example.servicethreaddemo;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    static TextView tv;
    Button bt1,bt2;
    Intent myIt=new Intent("gdmec07131030");
    static Handler myHandler=new Handler();
    private static double randomDouble;
    private static Runnable refreshlabel=new Runnable(){

		@Override
		public void run() {
			tv.setText(String.valueOf(randomDouble));
			
		}};
	public static void UpdateGUI(double refreshDouble){
		randomDouble=refreshDouble;
		myHandler.post(refreshlabel);
		
	}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView) findViewById(R.id.textView1);
        bt1=(Button) findViewById(R.id.button1);
        bt2=(Button) findViewById(R.id.button2);
        bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startService(myIt);
				
				
			}
		});
        bt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				stopService(myIt);
				
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
