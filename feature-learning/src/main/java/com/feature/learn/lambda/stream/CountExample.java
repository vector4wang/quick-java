package com.feature.learn.lambda.stream;

import java.util.stream.Stream;

public class CountExample {
    public static void main (String[] args) {
        runCount();
        runEquivalentReduce();
        runEquivalentSum();
    }

    private static void runCount () {
        long c = Stream.of("banana", "pie", "apple").count();
        System.out.println(c);
    }

    private static void runEquivalentReduce () {
        long sum = Stream.of("banana", "pie", "apple")
                         .mapToLong(s -> 1L)
                         .reduce(0, Long::sum);
        System.out.println(sum);
    }

    private static void runEquivalentSum () {
        long sum = Stream.of("banana", "pie", "apple")
                         .mapToLong(s -> 1L).sum();
        System.out.println(sum);
    }
}