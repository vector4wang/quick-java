package com.feature.learn.lambda.stream;

import java.util.Arrays;

public class PeekExample {

    public static void main(String... args) {
        String[] array = {"one", "two", "three", "four"};
        Arrays.stream(array).peek(System.out::println);
    }
}