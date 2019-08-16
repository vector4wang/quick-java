package com.feature.learn.lambda.collectors;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JoiningExample2 {
    public static void main(String[] args) {
        Stream<String> s = Stream.of("what", "so", "ever");
        String str = s.collect(Collectors.joining("|"));
        System.out.println(str);
    }
}