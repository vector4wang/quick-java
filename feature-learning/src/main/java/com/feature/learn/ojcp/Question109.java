package com.feature.learn.ojcp;

import java.util.ArrayList;

/**
 *
 * @author wangxc
 * @date: 2019-10-15 15:22
 *
 */
public class Question109 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("SE");
		list.add("EE");
		list.add("ME");
		list.add("SE");
		list.add("EE");
		list.remove("SE");
		System.out.println("Values are : " + list);
	}
}
