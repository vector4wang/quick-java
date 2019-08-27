package com.feature.learn.lambda.stream;

import java.util.stream.Stream;

public class MapExample2 {

    public static void main(String... args) {
        String[] s = {"one", "two", "three", "four"};
        Stream<String> stringStream = Stream.of(s);
        Stream<Character> charStream = stringStream.map(e -> e.charAt(0));
        charStream.forEach(System.out::println);
    }
}