package com.feature.learn.ojcp;

/**
 *
 * @author wangxc
 * @date: 2019-10-14 17:41
 *
 */
public class Question21 {
	public static void main(String[] args) {
		Question21 question21 = new Question21();
		try {
			question21.doPrint();
			question21.doList();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void doList() throws Exception {
		throw new Error("Error");
	}
	public void doPrint() throws Exception {
		throw new RuntimeException("Exception");
	}


}
