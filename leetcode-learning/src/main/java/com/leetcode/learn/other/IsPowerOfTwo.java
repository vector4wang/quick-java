package com.leetcode.learn.other;

/**
 *
 * @author wangxc
 * @date: 2019-09-01 22:04
 *
 */
public class IsPowerOfTwo {
	public static void main(String[] args) {
		int n = -2147483648;
		System.out.println(n + " isPowerOfTwo? " + isPowerOfTwo(n));
	}

	public static boolean isPowerOfTwo(int n) {
		if (n <= 0) {
			return false;
		}
		return ((n - 1) & n) == 0;
	}
}
