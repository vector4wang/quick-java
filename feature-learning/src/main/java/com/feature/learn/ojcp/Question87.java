package com.feature.learn.ojcp;

/**
 *
 * @author wangxc
 * @date: 2019-10-15 11:49
 *
 */
public class Question87 {

	public static void main(String[] args) {
		new Series().displaySeries();
	}
}

class Series {
	private boolean flag;

	public void displaySeries() {
		int num = 2;
		while (flag) {
			if (num % 7 == 0)
				flag = false;
			System.out.print(num);
			num += 2;
		}
	}
}