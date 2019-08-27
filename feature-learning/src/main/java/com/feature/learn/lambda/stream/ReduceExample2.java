package com.feature.learn.lambda.stream;

import java.util.Arrays;

public class ReduceExample2 {

    public static void main(String... args) {
        String[] array = {"one", "two", "three", "four"};
        String result = Arrays.stream(array)
                              .reduce("", (s, s2) -> s + "-" + s2);

        System.out.println(result);
    }
}