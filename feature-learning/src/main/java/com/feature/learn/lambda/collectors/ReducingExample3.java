package com.feature.learn.lambda.collectors;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReducingExample3 {
    public static void main (String[] args) {
        Stream<Integer> s = Stream.of(5, 10, 20, 50).parallel();
        String str = s.collect(Collectors.reducing(
                            "",
                            x -> Integer.toString(x),
                            (s1, s2) -> s1 + s2));
        System.out.println(str);
    }
}