package com.feature.learn.lambda.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BuilderExample {

    public static void main(String... args) {
        Stream.Builder<String> builder = Stream.builder();
        Stream<String> stream = builder.add("one").add("two").add("three")
                                       .build();
        List<String> list = stream.map(String::toUpperCase)
                                  .collect(Collectors.toList());
        System.out.println(list);
    }
}