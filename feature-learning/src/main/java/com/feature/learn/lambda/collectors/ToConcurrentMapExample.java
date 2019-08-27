package com.feature.learn.lambda.collectors;

import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToConcurrentMapExample {
	public static void main(String[] args) {
		Stream<String> s = Stream.of("apple", "banana", "orange");
		ConcurrentMap<Character, String> m = s
				.collect(Collectors.toConcurrentMap(s1 -> s1.charAt(0), String::toUpperCase));
		System.out.println(m);
	}
}