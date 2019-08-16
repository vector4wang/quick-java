package com.feature.learn.lambda.collectors;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountingExample {
    public static void main (String[] args) {
        Stream<String> s = Stream.of("apple", "banana", "orange");
        Long c = s.collect(Collectors.counting());
        System.out.println(c);
    }
}