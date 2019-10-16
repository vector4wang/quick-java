package com.feature.learn.ojcp;

/**
 *
 * @author wangxc
 * @date: 2019-10-15 21:27
 *
 */
public class Question154 {
	public static void main(String[] args) {
		float myarray[] = {10.20f, 20.30f, 30.40f, 50.60f};
		int index = 0;
		boolean isFound = false;
		float key = 30.40f;
		while (index++ < 5) { // 越界问题  ArrayIndexOutOfBounds
			System.out.println(index);
			if (key == myarray[index]) {
				isFound = true;
			}
		}
		System.out.println("isFound");
	}
}
