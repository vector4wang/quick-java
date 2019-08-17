package com.feature.learn.lambda.stream;

import java.util.Arrays;
import java.util.Optional;

public class MaxExample {

	public static void main(String... args) {
		String[] s = {"one", "two", "three", "four"};
		Optional<String> max = Arrays.stream(s).max(String::compareTo);
		if (max.isPresent()) {
			System.out.println(max.get());
		}
	}
}