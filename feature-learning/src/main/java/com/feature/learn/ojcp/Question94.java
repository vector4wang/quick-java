package com.feature.learn.ojcp;

/**
 *
 * @author wangxc
 * @date: 2019-10-15 10:35
 *
 */
public class Question94 {
	public static void main(String[] args) {
		String arra[][] = new String[3][];
		arra[0] = new String[]{"rose", "lily"};
		arra[1] = new String[]{"apple", "berry", "cherry", "grapes"};
		arra[0] = new String[]{"beans", "carrot", "potato"};
		// insert code fragment here
		for (int i = 0; i < arra.length; i++) {
			for (int j = 0; j < arra[i].length; j++) {
				arra[i][j] = arra[i][j].toUpperCase();
			}
		}
	}
}
