package com.feature.learn.lambda.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class ToArrayExample2 {

    public static void main(String... args) {
        String[] strings = Stream.of("one", "two", "three", "four")
                                 .filter(s -> s.startsWith("t"))
                                 .toArray(String[]::new);
        System.out.println(Arrays.toString(strings));
    }
}