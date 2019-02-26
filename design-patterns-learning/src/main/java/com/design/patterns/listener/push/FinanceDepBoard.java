package com.design.patterns.listener.push;


import com.design.patterns.listener.push.abs.BlackBoard;

public class FinanceDepBoard extends BlackBoard {

	public void publish(String msg) {
		notifyStaff(msg);
	}
}
