package com.feature.learn.lambda.stream;

import java.util.stream.IntStream;

public class SideEffectWithPeek {
    public static void main (String[] args) {
        IntStream.range(0, 5)
                 .unordered()
                 .parallel()
                 .map(x -> x * 2)
                 .peek(System.out::println)
                 .count();
    }
}