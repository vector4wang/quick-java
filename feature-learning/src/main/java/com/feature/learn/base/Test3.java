package com.feature.learn.base;

/**
 *
 * @author wangxc
 * @date: 2019-11-06 08:18
 *
 */
public class Test3 {
	public static void main(String[] args) {
		StringBuffer sb1 = new StringBuffer("1");
		StringBuffer sb2 = new StringBuffer("2");
		method(sb1, sb2);
		System.out.println(sb1+ " " + sb2);

	}

	private static void method(StringBuffer sb1, StringBuffer sb2) {
		sb1.append(sb2);
		sb2 = sb1;
	}
}
