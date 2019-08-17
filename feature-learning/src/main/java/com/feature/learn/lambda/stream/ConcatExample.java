package com.feature.learn.lambda.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class ConcatExample {

    public static void main(String... args) {
        Stream<String> s1 = Arrays.asList("one", "two", "three").stream();
        Stream<String> s2 = Arrays.asList("four", "five", "six").stream();

        Stream<String> s3 = Stream.concat(s1, s2);
        s3.forEach(System.out::println);
    }
}