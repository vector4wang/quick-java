package com.feature.learn.lambda.collectors;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToMapExample {
    public static void main (String[] args) {
        Stream<String> s = Stream.of("apple", "banana", "orange");
        Map<Character, String> m = s.collect(
                            Collectors.toMap(s1 -> s1.charAt(0),
                                                s1 -> s1));
        System.out.println(m);
    }
}