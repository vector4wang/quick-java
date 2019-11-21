package com.feature.learn.base;

/**
 *
 * @author wangxc
 * @date: 2019-11-06 08:18
 *
 */
public class Test2 {
	public static void main(String[] args) {
		Object o = new Object() {
			@Override
			public boolean equals(Object obj) {
				return true;
			}
		};
		System.out.println(o.equals("abc"));
	}
}
