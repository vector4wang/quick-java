package com.feature.learn.ojcp;

/**
 *
 * @author wangxc
 * @date: 2019-10-15 11:44
 *
 */
public class Question106 {
	static boolean bVar;

	public static void main(String[] args) {
		boolean bVar1 = true;
		int count = 8;
		do {
			System.out.println("Hello Java! " + count);
			if (count >= 7) {
				bVar1 = false;
			}
		} while (bVar != bVar1 && count > 4);
		count -= 2;
	}
}
