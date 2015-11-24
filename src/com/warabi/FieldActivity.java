package com.warabi;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class FieldActivity extends BaseActivity {
	static String[] rand = {"1", "2", "3", "4", "5", "6"};
	static String[] status = {"HP", "攻撃力", "防御力", "甘さ", "食感", "英語力", "足の早さ", "オシャレ度", "歌唱力", "演技力", "対空性能"};

	Toast my_toast;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_field);
		mpStop();
		mpChange(R.raw.bgm);
		mpStart();

		Button button2 = (Button)findViewById(R.id.button2);
		button2.setText("戻る");
		button2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
		        Intent intent = new Intent();
		        intent.setClassName("com.warabi", "com.warabi.MainActivity");
		        startActivity(intent);
			}
		});
		Button dice = (Button)findViewById(R.id.dice);
		dice.setText("能力を上げる");
		dice.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				List<String> lis = Arrays.asList(rand);
				List<String> lis_st = Arrays.asList(status);
    			Collections.shuffle(lis);
    			Collections.shuffle(lis_st);
    			String[] rand2 = (String[])lis.toArray(new String[lis.size()]);
    			String[] status2 = (String[])lis_st.toArray(new String[lis_st.size()]);
    			String result_rand = rand2[0];
    			String result_status = status2[0];
    			String lvup_news = result_status + "が" + result_rand + "上がりました";

    			SharedPreferences data = getSharedPreferences("DataSave", Context.MODE_PRIVATE);
    			SharedPreferences.Editor e = data.edit();
    			int stlv = data.getInt(result_status, 0);
    			if (result_rand=="1") {
    				stlv = stlv + 1;
    			} else if (result_rand=="2"){
    				stlv = stlv + 2;
    			} else if(result_rand=="3") {
    				stlv = stlv + 3;
    			} else if(result_rand=="4") {
    				stlv = stlv + 4;
    			} else if(result_rand=="5") {
    				stlv = stlv + 5;
    			} else if(result_rand=="6") {
    				stlv = stlv + 6;
    			}

    			e.putInt(result_status, stlv);
    			e.apply();

    			if (my_toast != null) {
    				my_toast.cancel();
    			}
    			my_toast = Toast.makeText(getApplicationContext(), lvup_news,Toast.LENGTH_SHORT);
    			my_toast.show();
			}
		});
	}
}