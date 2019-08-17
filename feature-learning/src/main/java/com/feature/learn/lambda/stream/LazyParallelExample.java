package com.feature.learn.lambda.stream;

import java.util.stream.IntStream;

public class LazyParallelExample {
	//	private static Logger log = Logger.getLogger(this.getClass().getName());

	public static void main(String[] args) {
		IntStream stream = IntStream.range(1, 5).parallel();
		stream = stream.peek(i -> System.out.println("starting " + i)).filter(i -> {
			System.out.println("filtering " + i);
			return i % 2 == 0;
		}).peek(i -> System.out.println("post filtering: "+ i));
		System.out.println("Invoking terminal method count.");
		System.out.println("The count is: " + stream.count());
	}
}
