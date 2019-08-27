package com.feature.learn.lambda.stream;

import java.util.stream.IntStream;

/**
 * 用排序的foreach性能较差，最好不用
 * @author wangxc
 * @date: 2019-08-17 10:20
 *
 */
public class ForEachExample2 {
	public static void main (String[] args) {
		final int[] ints = IntStream.range(0, 5).toArray();
//		PerformanceTestUtil.runTest("forEach() method", () -> {
//			Arrays.stream(ints).parallel().forEach(i -> doSomething(i));
//		});
//
//		PerformanceTestUtil.runTest("forEachOrdered() method", () -> {
//			Arrays.stream(ints).parallel().forEachOrdered(i -> doSomething(i));
//		});
	}

	private static void doSomething (int i) {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("%s, ", i);
	}
}
