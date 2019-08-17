package com.feature.learn.lambda.stream;

import java.util.stream.Stream;

public class EmptyExample {

    public static void main(String... args) {
        Stream<Object> myStream = Stream.empty();
        someMethod(myStream);
    }

    public static void someMethod(Stream<?> stream) {
        stream.forEach(System.out::println);
    }
}
