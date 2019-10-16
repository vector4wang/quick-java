package com.feature.learn.ojcp;

/**
 *
 * @author wangxc
 * @date: 2019-10-15 10:57
 *
 */
public class Question99 {
	static void dispResult(int[] num) {
		try {
			System.out.println(num[1] / (num[1] - num[2]));
		} catch (ArithmeticException e) {
			System.out.println("first exception");
		}
		System.out.println("Done");
	}

	public static void main(String[] args) {
		try {
			int[] arr = {100, 100};
			dispResult(arr);
		} catch (IllegalArgumentException e) {
			System.err.println("Second exception");
		} catch (Exception e) {
			System.err.println("third exception");
		}
	}
}
