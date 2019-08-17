package com.feature.learn.lambda.stream;

import java.util.stream.Stream;

public class SortedExample {
//Stream<T> sorted()

    public static void main(String... args) {
        String[] s = {"one", "two", "three", "four"};

        System.out.println("-- sequential --");
        Stream.of(s)
              .sorted()
              .forEach(System.out::println);

        System.out.println("-- parallel --");
        Stream.of(s)
              .parallel()
              .sorted()
              .forEach(System.out::println);
    }
}