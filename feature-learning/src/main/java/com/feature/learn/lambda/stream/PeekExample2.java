package com.feature.learn.lambda.stream;

import java.util.stream.IntStream;

/**
 *
 * @author wangxc
 * @date: 2019-08-17 19:22
 *
 */
public class PeekExample2 {
	public static void main (String[] args) {
		IntStream.range(0, 5).parallel().peek(System.out::println).
				count();
	}
}
