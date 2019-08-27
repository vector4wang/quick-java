package com.feature.learn.lambda.stream;

import java.util.stream.Stream;

public class GenerateExample {

    public static void main(String... args) {
        Stream<String> stream = Stream.generate(() ->
                Double.toString(Math.random() * 1000)).limit(10);

        stream.forEach(System.out::println);
    }
}