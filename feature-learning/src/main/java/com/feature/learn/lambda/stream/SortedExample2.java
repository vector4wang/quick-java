package com.feature.learn.lambda.stream;

import java.util.stream.Stream;

public class SortedExample2 {

    public static void main(String... args) {
        String[] s = {"one", "two", "three", "four"};

        Stream.of(s)
              .sorted((a, b) ->
                      Character.compare(a.charAt(a.length() - 1),
                              b.charAt(b.length() - 1)))
              .forEach(System.out::println);
    }
}