package com.feature.learn.lambda.collectors;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReducingExample {
    public static void main(String[] args) {
        Stream<Integer> s = Stream.of(5, 10, 20, 50);
        Integer i = s.collect(Collectors.reducing((integer, integer2)
                -> integer2 - integer))
                .orElse(-1);

        System.out.println(i);
    }
}