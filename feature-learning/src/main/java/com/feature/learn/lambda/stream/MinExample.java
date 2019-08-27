package com.feature.learn.lambda.stream;

import java.util.Arrays;
import java.util.Optional;

public class MinExample {

    public static void main(String... args) {
        String[] s = {"one", "two", "three", "four"};
        Optional<String> min = Arrays.stream(s)
                                     .min(String::compareTo);
        if (min.isPresent()) {
            System.out.println(min.get());
        }
    }
}