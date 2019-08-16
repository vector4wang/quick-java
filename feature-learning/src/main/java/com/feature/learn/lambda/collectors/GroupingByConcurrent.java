package com.feature.learn.lambda.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingByConcurrent {
    public static void main(String[] args) {
        Stream<String> s = Stream.of("apple", "banana", "orange");
        Map<Integer, List<String>> map = s.collect(
                Collectors.groupingByConcurrent(String::length));
        System.out.println(map);
    }
}