package com.feature.learn.lambda.collectors;

import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingByExample3 {
    public static void main(String[] args) {
        Stream<String> s = Stream.of("apple", "banana", "orange");
        //cascaded group by
        ConcurrentHashMap<Integer, Long> map = s.collect(
                Collectors.groupingBy(String::length,
                        ConcurrentHashMap::new,
                        Collectors.counting()));
        System.out.println(map);
    }
}