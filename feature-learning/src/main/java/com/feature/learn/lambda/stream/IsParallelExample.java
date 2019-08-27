package com.feature.learn.lambda.stream;

import java.util.stream.Stream;

public class IsParallelExample {

    public static void main(String... args) {
        Stream<String> stream = Stream.of("one", "two", "three", "four");
        stream = stream.parallel();
        System.out.println(stream.isParallel());
    }
}