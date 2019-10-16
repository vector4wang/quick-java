package com.feature.learn.ojcp;

/**
 *
 * @author wangxc
 * @date: 2019-10-15 08:41
 *
 */
public class MultiPlus {
	public static void main(String[] args) {
		int i = 1;
		int j = i++;
		int k = ++i;
		System.out.println(i);
		System.out.println(j);
		System.out.println(k);
		int m = 0;
		for (int l = 0; l < 100; l++) {
			m = m++;
		}
	}
}
