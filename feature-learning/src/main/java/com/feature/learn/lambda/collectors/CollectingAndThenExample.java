package com.feature.learn.lambda.collectors;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingAndThenExample {
    public static void main(String[] args) {
        Stream<String> s = Stream.of("apple", "banana", "orange");
        List<String> synchronizedList = s.collect(Collectors.collectingAndThen(
                Collectors.toList(), Collections::synchronizedList));
        System.out.println(synchronizedList);
    }
}