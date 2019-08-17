package com.feature.learn.lambda.stream;

import java.util.Optional;
import java.util.stream.Stream;

public class FindFirstExample {

    public static void main(String... args) {
        Stream<Object> s = Stream.empty();
        Optional<Object> opt = s.findFirst();
        System.out.println(opt.isPresent());
    }
}