package com.warabi;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;

public class CalActivity extends BaseActivity implements OnClickListener {
	private DisplayPanel dispPnl = null;
	private Calculator engine = null;
	private String[][] keyName = {
			{"", "", "AC", "C" },
			{"7", "8", "9", "÷"},
			{"4", "5", "6", "*" },
			{"1", "2", "3", "-" },
			{"0", ".", "=", "+" }
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.acitivity_cal);
		mpStop();
		mpChange(R.raw.bgm);
		mpStart();

		LinearLayout layout0 = new LinearLayout(this);
		layout0.setOrientation(LinearLayout.VERTICAL);
		layout0.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		setContentView(layout0);

		TextView display = new TextView(this);
		display.setText("0");
		display.setTextSize(30.0f);
		display.setTextColor(Color.rgb(0xFF,  0xFF, 0xFF));
		display.setBackgroundColor(Color.rgb(0x00, 0x00, 0x00));
		display.setGravity(Gravity.END);
		display.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		layout0.addView(display);

		dispPnl = new DisplayPanel(display);
		engine = new Calculator(dispPnl);

		TableLayout layout = new TableLayout(this);
		TableLayout.LayoutParams lp = new TableLayout.LayoutParams(
				TableLayout.LayoutParams.MATCH_PARENT,
				TableLayout.LayoutParams.MATCH_PARENT, 1);
		layout0.addView(layout, lp);
		TableRow.LayoutParams lpRow = new TableRow.LayoutParams(
				TableRow.LayoutParams.MATCH_PARENT,
				TableRow.LayoutParams.MATCH_PARENT, 1);

		for (int row = 0; row < keyName.length; row++) {
			TableRow tRow = new TableRow(this);
			tRow.setLayoutParams(lp);

			for (int col = 0; col < keyName[row].length; col++) {
				Button btn = new Button(this);
				btn.setText(keyName[row][col]);
				if (keyName[row][col].equals(""))
					btn.setVisibility(View.INVISIBLE);
				btn.setOnClickListener(this);
				btn.setBackgroundColor(Color.rgb(0x40, 0x40, 0x40));
				btn.setTextColor(Color.rgb(0xFF, 0xFF, 0xFF));
				tRow.addView(btn, lpRow);
			}
			layout.addView(tRow);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public void onClick(View v) {
		String nm = ((Button)v).getText().toString();
		System.out.println("onClick=" + nm);
		engine.calculate(nm);
	}
}
