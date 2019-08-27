package com.feature.learn.lambda.stream;

import java.util.stream.Stream;

public class FilterExample {

    public static void main(String... args) {
        Stream<String> s = Stream.of("one", "two", "three", "four");
        Stream<String> s2 = s.filter(e -> e.endsWith("e"));
        s2.forEach(System.out::println);
    }
}