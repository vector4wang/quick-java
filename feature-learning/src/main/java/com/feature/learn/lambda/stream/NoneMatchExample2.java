package com.feature.learn.lambda.stream;

import java.util.stream.Stream;

public class NoneMatchExample2 {

    public static void main(String... args) {
        boolean b = Stream.empty()
                          .noneMatch(e -> false);
        System.out.println(b);
    }
}