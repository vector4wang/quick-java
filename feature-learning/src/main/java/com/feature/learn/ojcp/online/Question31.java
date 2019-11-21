package com.feature.learn.ojcp.online;

/**
 *
 * @author wangxc
 * @date: 2019-11-20 09:24
 *
 */
public class Question31 {
	public static void main(String[] args) {
		boolean b1 = false;
		boolean b2 = false;
		if (b2 != b1 == !b2) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}
}
