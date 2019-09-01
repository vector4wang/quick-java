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
		System.out.println(Objects.hashCode("La's")); // 2358657
		System.out.println(Objects.hashCode("MB's")); // 2358657
	}
}
