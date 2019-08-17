package com.feature.learn.lambda.collectors;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToMapExample2 {
    public static void main (String[] args) {
        Stream<String> s = Stream.of("apple", "banana", "apricot", "orange",
                            "apple");
        Map<Character, String> m = s.collect(
                            Collectors.toMap(s1 -> s1.charAt(0),
                                                s1 -> s1,
                                                (s1, s2) -> s1 + "|" + s2));
        System.out.println(m);
    }
}