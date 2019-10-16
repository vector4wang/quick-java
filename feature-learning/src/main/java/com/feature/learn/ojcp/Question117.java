package com.feature.learn.ojcp;

/**
 *
 * @author wangxc
 * @date: 2019-10-15 15:47
 *
 */
public class Question117 {
	public static void main(String[] args) {
		StringBuilder sb1 = new StringBuilder("Duke");
		String str1 = sb1.toString();// new String();
		// insert code here
		//String str2 = sb1.toString();
		String str2 = str1;
		System.out.print(str1 == str2);
	}
}
