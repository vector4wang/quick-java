package com.feature.learn.lambda.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class OnCloseExample {

	public static void main(String... args) {
		String[] s = {"one", "two", "three", "four"};
		Stream<String> stream = Arrays.stream(s).onClose(() -> {
			System.out.println("-- closing stream --");
		});
		stream.forEach(System.out::println);
		System.out.println("-- going to close --");
		stream.close();
	}
}