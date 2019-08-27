package com.feature.learn.lambda.stream;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class ParallelExample {

	public static void main(String... args) {
		Stream.iterate(1L, a -> a + 1).limit(5).parallel().forEach(ParallelExample::process);
	}

	private static void process(Long aLong) {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(LocalDateTime.now());
	}
}