package com.feature.learn.lambda.collectors;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaxByExample {
    public static void main(String[] args) {
        Stream<String> s = Stream.of("orange", "apple", "banana");
        Optional<String> o = s.collect(
                Collectors.maxBy(String::compareTo));
        System.out.println(o.get());
    }
}