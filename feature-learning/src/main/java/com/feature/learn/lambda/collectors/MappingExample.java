package com.feature.learn.lambda.collectors;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MappingExample {
    public static void main(String[] args) {
        Stream<String> s = Stream.of("apple", "banana", "orange");
        List<String> list = s.collect(Collectors.mapping(s1 -> s1.substring(0, 2),
                Collectors.toList()));
        System.out.println(list);
    }
}