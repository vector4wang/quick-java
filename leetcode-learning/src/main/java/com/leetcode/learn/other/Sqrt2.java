package com.leetcode.learn.other;

/**
 *已知 sqrt (2)约等于 1.414，要求不用数学库，求 sqrt (2)精确到小数点后 10 位
 * @author wangxc
 * @date: 2019-08-08 08:20
 *
 */
public class Sqrt2 {

	final static double EPSILON = 0.0000000001;

	public static void main(String[] args) {
		double low = 1.4;
		double high = 1.5;
		double mid = (high + low) / 2;
		while (high - low > EPSILON) {
			System.out.println(high + ": " + low);
			if (mid * mid > 2) {
				high = mid;
			}else{
				low = mid;
			}

			mid = (high + low) / 2;
		}
		System.out.println(mid);

	}
}
