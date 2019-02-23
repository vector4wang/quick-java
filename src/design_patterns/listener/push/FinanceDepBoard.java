package design_patterns.listener.push;

import design_patterns.listener.push.abs.BlackBoard;

public class FinanceDepBoard extends BlackBoard {

	public void publish(String msg) {
		notifyStaff(msg);
	}
}
