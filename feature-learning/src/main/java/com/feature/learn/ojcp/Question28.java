package com.feature.learn.ojcp;

/**
 *
 * @author wangxc
 * @date: 2019-10-14 23:03
 *
 */
public class Question28 {
	public static void main(String[] args) {
		String ta = "A ";
		ta = ta.concat("B ");
		String tb = "C ";
		ta = ta.concat(tb);
		ta.replace('C', 'D'); // 需要返回值
		ta = ta.concat(tb);
		System.out.println(ta);

	}
}
