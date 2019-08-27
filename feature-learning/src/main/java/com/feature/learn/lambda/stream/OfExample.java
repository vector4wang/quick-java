package com.feature.learn.lambda.stream;

import java.util.stream.Stream;

public class OfExample {

    public static void main(String... args) {
        Stream<Long> stream = Stream.of(1L);
        stream.forEach(System.out::println);

    }
}