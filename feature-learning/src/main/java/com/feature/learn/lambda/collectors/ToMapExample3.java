package com.feature.learn.lambda.collectors;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToMapExample3 {
	public static void main(String[] args) {
		Stream<String> s = Stream.of("apple", "banana", "apricot", "orange", "apple");
		LinkedHashMap<Character, String> m = s
				.collect(Collectors.toMap(s1 -> s1.charAt(0), s1 -> s1, (s1, s2) -> s1 + "|" + s2, LinkedHashMap::new));
		System.out.println(m);
	}
}