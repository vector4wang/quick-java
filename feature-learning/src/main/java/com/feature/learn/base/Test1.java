package com.feature.learn.base;

/**
 *
 * @author wangxc
 * @date: 2019-11-05 17:52
 *
 */
public class Test1 {
	public static void main(String[] args) {
		byte i1 = 3, i2 = 4, i4, i5;
		//		final byte i6 = 7,i7=8,i5=0;
		int x = 10, y = 11;
		System.out.println("sum: " + method(x, y));


	}

	static int method(int a, int b) {
		try {
			return a + b;
		} catch (Exception e) {
			System.out.println("cache");
		} finally {
			System.out.println("finally");
		}
		return 0;
	}
}
