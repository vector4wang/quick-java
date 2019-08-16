package com.feature.learn.lambda.collectors;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReducingExample2 {
    public static void main(String[] args) {
        Stream<Integer> s = Stream.of(5, 10, 20, 50);
        Integer i = s.collect(Collectors.reducing(1, (integer, integer2)
                -> integer2 * integer));
        System.out.println(i);
    }
}