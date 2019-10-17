package com.feature.learn.ojcp.question89;

/**
 *
 * @author wangxc
 * @date: 2019-10-17 16:47
 *
 */
public class Question12 {

	void readCard(int cardNo) throws Exception {
		System.out.println("reading card");
	}

	void checkCard(int cardNo) throws RuntimeException {
		System.out.println("checking card");
	}

	public static void main(String[] args) {
		Question12 question12 = new Question12();
		int cardNo = 12344;
		question12.checkCard(cardNo);
//		question12.readCard(cardNo);// checked exception
	}
}
