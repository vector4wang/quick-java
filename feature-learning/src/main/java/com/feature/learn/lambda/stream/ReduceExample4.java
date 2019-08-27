package com.feature.learn.lambda.stream;

import java.util.Arrays;

public class ReduceExample4 {

	public static void main(String... args) {
		String[] array = {"one", "two", "three", "four"};
		String result = Arrays.stream(array).parallel().reduce("", (s, s2) -> s + "-" + s2, (s, s2) -> s + "|" + s2);
		System.out.println(result);
	}
}