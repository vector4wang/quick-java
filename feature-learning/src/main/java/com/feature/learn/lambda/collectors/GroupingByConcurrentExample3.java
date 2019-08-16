package com.feature.learn.lambda.collectors;

import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingByConcurrentExample3 {
    public static void main(String[] args) {
        Stream<String> s = Stream.of("apple", "banana", "orange");
        //cascaded group by
        ConcurrentSkipListMap<Integer, Long> map = s.collect(
                Collectors.groupingByConcurrent(String::length,
                        ConcurrentSkipListMap::new,
                        Collectors.counting()));
        System.out.println(map);
    }
}