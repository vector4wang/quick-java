package com.feature.learn.ojcp;

/**
 *
 * @author wangxc
 * @date: 2019-10-15 22:14
 * 基础类型不能直接强转字符串
 *
 */
public class Question161 {
	public static void main(String[] args) {
		Short s1 = 200;
		Integer s2 = 400;
		Long s3 = (long) s1 + s2;			//line n1
//		String s4 = (String) (s3 * s2);		//line n2
//		String s5 = (String) s2;
//		System.out.println("Sum is " + s4);
	}
}
