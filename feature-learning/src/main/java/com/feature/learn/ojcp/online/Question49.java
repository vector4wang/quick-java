package com.feature.learn.ojcp.online;

/**
 *
 * @author wangxc
 * @date: 2019-11-18 11:07
 *
 */
public class Question49 {
	public static void main(String args []){
		String s = "MINIMUM";
		System.out.println(s.substring(4, 7)); //1
		System.out.println(s.substring(5)); //2
		System.out.println(s.substring(s.indexOf('I', 3))); //3
		System.out.println(s.substring(s.indexOf('I', 4))); //4
	}
}
