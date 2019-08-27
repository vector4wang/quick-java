package com.feature.learn.lambda.stream;

import java.util.stream.Stream;

public class MapExample {

    public static void main(String... args) {
        String[] s = {"one", "two", "three", "four"};
        Stream<String> stringStream = Stream.of(s);
        Stream<Integer> intStream = stringStream.map(String::length);
        intStream.forEach(System.out::println);
    }
}