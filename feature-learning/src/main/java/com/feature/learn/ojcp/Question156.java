package com.feature.learn.ojcp;

/**
 *
 * @author wangxc
 * @date: 2019-10-15 21:48
 * 假如存在default 如果case中没有满足的条件，不管default在哪里，
 * 都需要执行，并且一直执行到有break或语句结束
 */
public class Question156 {
	public static void main(String[] args) {
		String s = "A";
		switch (s) {
			default:
				System.out.println("default");
			case "a":
				System.out.println("simaple A");
			case "B":
				System.out.println("Captial A");
		}
	}
}
