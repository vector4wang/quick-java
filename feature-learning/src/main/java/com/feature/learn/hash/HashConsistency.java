package com.feature.learn.hash;

import java.util.Objects;

/**
 * Hash 一致性
 * @author wangxc
 * @date: 2019-08-26 21:49
 *
 */
public class HashConsistency {

	private final static int node = 4;

	public static void main(String[] args) {
		String key = "zloqnelvhjfadfoia";

		System.out.println(key.hashCode());
		System.out.println(Objects.hash(key));

		Person person = new Person(11,"zloqnelvhjfadfoia");
		System.out.println(person.hashCode());
	}


}
