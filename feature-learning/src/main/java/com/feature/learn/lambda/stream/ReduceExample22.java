package com.feature.learn.lambda.stream;

import java.util.stream.IntStream;

/**
 *
 * @author wangxc
 * @date: 2019-08-17 19:39
 *
 */
public class ReduceExample22 {
	public static void main (String[] args) {
		int i = IntStream.range(1, 6)
				.parallel()
				.reduce(1, (a, b) -> a * b);

		System.out.println(i);
	}
}
