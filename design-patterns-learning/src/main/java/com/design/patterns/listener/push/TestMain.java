package com.design.patterns.listener.push;

/**
 * 1、每个员工首先注册获取黑板报的知情权，黑板报会把所有注册的人记起来
 * 2、注册的员工需要拿对讲机来接受信息
 * 3、黑板报一旦更新，则会通知所有注册人员
 */
public class TestMain {
	public static void main(String[] args) {
		FinanceDepBoard financeDepBoard = new FinanceDepBoard();
		financeDepBoard.register(new ItStaff());
		financeDepBoard.register(new SalesEmp());


//		FinanceDepBoard financeDepBoard = new FinanceDepBoard();
		financeDepBoard.publish("这个月资金困难，工资下个月发");
	}
}
