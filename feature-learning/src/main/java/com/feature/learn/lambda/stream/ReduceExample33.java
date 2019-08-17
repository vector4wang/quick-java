package com.feature.learn.lambda.stream;

import java.util.stream.Stream;

/**
 *
 * @author wangxc
 * @date: 2019-08-17 19:40
 *
 */
public class ReduceExample33 {
	public static void main (String[] args) {
		int i = Stream.of("2", "3", "4", "5")
				.parallel()
				.reduce(0, (integer, s) -> Integer.sum(integer, Integer.parseInt(s)),
						(integer, integer2) -> Integer.sum(integer, integer2));

		System.out.println(i);
	}
}
