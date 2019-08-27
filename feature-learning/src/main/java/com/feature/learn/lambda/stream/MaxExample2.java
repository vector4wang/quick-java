package com.feature.learn.lambda.stream;

import java.util.Arrays;
import java.util.Optional;

public class MaxExample2 {

	public static void main(String... args) {
		String[] s = {"one", "two", "three", "four"};
		Optional<String> max = Arrays.stream(s)
				.max((s1, s2) -> Character.compare(s1.charAt(s1.length() - 1), s2.charAt(s2.length() - 1)));
		if (max.isPresent()) {
			System.out.println(max.get());
		}
	}
}