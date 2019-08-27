package com.feature.learn.lambda.stream;

import java.util.Arrays;
import java.util.Optional;

public class ReduceExample {

    public static void main(String... args) {
        String[] array = {"one", "two", "three", "four"};
        Optional<String> opt = Arrays.stream(array).reduce((s, s2) -> s + "-" + s2);

        if (opt.isPresent()) {
            System.out.println(opt.get());
        }
    }
}