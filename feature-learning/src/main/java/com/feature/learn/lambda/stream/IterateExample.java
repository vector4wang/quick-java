package com.feature.learn.lambda.stream;

import java.util.stream.Stream;

public class IterateExample {

    public static void main(String... args) {
        Stream<Integer> stream = Stream.iterate(0, i -> i + 1)
                                       .limit(10);
        stream.forEach(System.out::println);
    }
}