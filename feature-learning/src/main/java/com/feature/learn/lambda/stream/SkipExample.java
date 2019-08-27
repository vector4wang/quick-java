package com.feature.learn.lambda.stream;

import java.util.stream.Stream;

public class SkipExample {

    public static void main(String... args) {
        String[] s = {"one", "two", "three", "four"};

        Stream.of(s)
              .skip(2)
              .forEach(System.out::println);
    }
}