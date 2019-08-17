package com.feature.learn.lambda.stream;

import java.util.stream.Stream;

public class ForEachExample {

    public static void main(String... args) {
        Stream<String> s = Stream.of("one", "two", "three", "four");
        s.forEach(System.out::println);
    }
}