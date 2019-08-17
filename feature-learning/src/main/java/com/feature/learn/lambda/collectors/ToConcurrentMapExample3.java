package com.feature.learn.lambda.collectors;

import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToConcurrentMapExample3 {
    public static void main (String[] args) {
        Stream<String> s = Stream.of("apple", "banana", "apricot", "orange");
        ConcurrentHashMap<Character, String> m = s.collect(
                            Collectors.toConcurrentMap(s1 -> s1.charAt(0),
                                                String::toUpperCase,
                                                (s1, s2) -> s1 + "|" + s2,
                                                ConcurrentHashMap::new));
        System.out.println(m);
    }
}