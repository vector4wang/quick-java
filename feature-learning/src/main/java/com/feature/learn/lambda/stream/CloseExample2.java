package com.feature.learn.lambda.stream;

import java.util.stream.Stream;

public class CloseExample2 {

    public static void main(String... args) {
        Stream<String> stream = Stream.of("one", "two", "three", "four");
        stream.close();
        stream.forEach(System.out::println);
    }
}