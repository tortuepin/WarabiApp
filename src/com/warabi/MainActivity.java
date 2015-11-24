package com.warabi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends BaseActivity  {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		mp.start();

		Button button1 = (Button)findViewById(R.id.button1);
		button1.setText("フィールド");
		button1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
		    Intent intent = new Intent();
		    intent.setClassName("com.warabi", "com.warabi.FieldActivity");
		    startActivity(intent);
	        }
		});
		Button button3 = (Button)findViewById(R.id.button3);
		button3.setText("ステータス");
		button3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClassName("com.warabi", "com.warabi.StatusActivity");
				startActivity(intent);
			}
		});
		Button btncal = (Button)findViewById(R.id.cal);
		btncal.setText("おまけ1");
		btncal.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClassName("com.warabi", "com.warabi.CalActivity");
				startActivity(intent);
			}
		});
		Button btnexit = (Button)findViewById(R.id.exit);
		btnexit.setText("終了");
		btnexit.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				moveTaskToBack(true);
				mpStop();
			}
		});
	}
}


