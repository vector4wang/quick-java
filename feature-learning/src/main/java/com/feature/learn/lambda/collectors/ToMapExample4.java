package com.feature.learn.lambda.collectors;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToMapExample4 {
    public static void main(String[] args) {
        Stream<String> s = Stream.of("apple", "banana", "apricot", "orange", "apple", "apple", "apple");
        Map<String, Integer> collect = s.collect(Collectors.toMap(s1 -> s1, s12 -> 1, Integer::sum));
        System.out.println(collect);
    }
}