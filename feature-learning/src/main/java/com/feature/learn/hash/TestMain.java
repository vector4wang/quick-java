package com.feature.learn.hash;

import java.util.Objects;

/**
 *
 * @author wangxc
 * @date: 2019-08-28 22:09
 *
 */
public class TestMain {
	public static void main(String[] args) {
		String s1 = "abc";
		System.out.println(Objects.hashCode(s1));
		System.out.println(Objects.hash(s1));
	}
}
