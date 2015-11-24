package com.warabi;

import android.widget.TextView;

public class DisplayPanel {
	private TextView dispTxt00 = null;
	private String dispContent = "";

	public DisplayPanel(TextView disp) {
		dispTxt00 = disp;
	}

	public String addDispContent(String tgt) {
		dispContent += tgt;
		return dispContent;
	}

	public void setDispContent(String tgt) {
		dispContent = tgt;
	}

	public String getDispContent() {
		return dispContent;
	}

	public void display(String tgt) {
		dispContent = tgt;
		dispTxt00.setText(dispContent);
	}

	public void display() {
		dispTxt00.setText(dispContent);
	}
}
