package com.feature.learn.lambda.stream;

import java.util.stream.Stream;

public class DistinctExample {

    public static void main(String... args) {
        Stream<String> s = Stream.of("one", "two", "three", "four", "two", "one");
        Stream<String> s2 = s.distinct();
        s2.forEach(System.out::println);
    }
}