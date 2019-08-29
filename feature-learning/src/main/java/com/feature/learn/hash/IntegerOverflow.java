package com.feature.learn.hash;

/**
 *
 * @author wangxc
 * @date: 2019-08-28 23:19
 *
 */
public class IntegerOverflow {
	public static void main(String[] args) {
//				int x = 10;
		int x = 9;
		for (int i = 0; i <= 5; i++) {
			x = x * x;
			System.out.println(x + " : " + Integer.toBinaryString(x));
		}
	}
}
