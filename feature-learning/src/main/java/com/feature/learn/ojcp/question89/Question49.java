package com.feature.learn.ojcp.question89;

/**
 *
 * @author wangxc
 * @date: 2019-10-17 22:33
 *
 */
public class Question49 {
	public static void main(String[] args) {
		int n[][] = {{1, 3}, {2, 4}};
		for (int i = n.length - 1; i >= 0; i--) {
			for (int i1 : n[i]) {
				System.out.println(i1);
			}
		}
	}
}
