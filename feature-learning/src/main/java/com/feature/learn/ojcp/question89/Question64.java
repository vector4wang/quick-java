package com.feature.learn.ojcp.question89;

import java.time.LocalDateTime;

/**
 *
 * @author wangxc
 * @date: 2019-10-17 23:00
 *
 */
public class Question64 {
	public static void main(String[] args) {
		int numbers[];
		numbers = new int[2];
		numbers[0] = 10;
		numbers[1] = 20;
		numbers = new int[4];
		numbers[2] = 30;
		numbers[3] = 40;
		for (int number : numbers) {
			System.out.println(number);
		}
		String mystr = "Hello World";
		mystr.trim();
		int i = mystr.indexOf(" ");
		System.out.println(i);
		LocalDateTime dt = LocalDateTime.of(2014, 7, 31, 1, 1);
		LocalDateTime localDateTime = dt.plusDays(30);

	}
}
