package com.feature.learn.ojcp.question89;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author wangxc
 * @date: 2019-10-17 23:44
 *
 */
public class Question85 {
	public static void main(String[] args) {
		String arr[] = {"hi", "How", "Are", "you"};
		ArrayList<String> strings = new ArrayList<>(Arrays.asList(arr));
		if (strings.removeIf(s -> s.length() <= 2)) {
//			System.out.println(s+"removed");
		}
	}
}
