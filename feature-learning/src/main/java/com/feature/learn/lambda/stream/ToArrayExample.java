package com.feature.learn.lambda.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class ToArrayExample {

    public static void main(String... args) {
        Stream<String> stream = Stream.of("one", "two", "three", "four");
        Object[] objects = stream.toArray();
        System.out.println(Arrays.toString(objects));
    }
}