package com.warabi;

public class Calculator {
	private DisplayPanel dispPnl;
	double stackedValue = 0.0;
	boolean isStacked = false;
	boolean afterOp = false;
	String currentOp = "";

	public Calculator(DisplayPanel dispPnl) {
		this.dispPnl = (DisplayPanel)dispPnl;
	}

	public void calculate(String key) {
		if (key.equals("0") || key.equals("1") || key.equals("2") || key.equals("3")
				||key.equals("4") ||key.equals("5")||key.equals("6")||key.equals("7")
				||key.equals("8") ||key.equals("9") ||key.equals(".")) {
			appendToDispContent(key);
		} else if (key.equals("C") || key.equals("AC")) {
			dispPnl.setDispContent("");
			dispPnl.display();
		} else if(key.equals("+") || key.equals("-") || key.equals("*") || key.equals("÷") || key.equals("=")) {
			if (isStacked) {
				double resultValue = (Double.valueOf(dispPnl.getDispContent())).doubleValue();
				if (currentOp.equals("+")) {
					stackedValue += resultValue;
				} else if (currentOp.equals("-")) {
					stackedValue -= resultValue;
				}
				if (currentOp.equals("*")) {
					stackedValue *= resultValue;
				}
				if (currentOp.equals("÷")) {
					stackedValue /= resultValue;
				}
				dispPnl.setDispContent(String.format("%10f", stackedValue));
			}

			currentOp = key;
			stackedValue = (Double.valueOf(dispPnl.getDispContent())).doubleValue();
			afterOp = true;
			if (currentOp.equals("=")) {
				isStacked = false;
			} else {
				isStacked = true;
			}
			dispPnl.display();
		}
	}

	private void appendToDispContent(String key) {
		if (!afterOp) {
			dispPnl.setDispContent(dispPnl.getDispContent() + key);
		} else {
			dispPnl.setDispContent(key);;
			afterOp = false;
		}
		dispPnl.display();
	}
}
