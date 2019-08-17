package com.feature.learn.lambda.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {

    public static void main(String... args) {
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("one", "two"),
                Arrays.asList("five", "six"),
                Arrays.asList("three", "four")
        );

        List<String> result = listOfLists.stream()
                                         .flatMap(childList -> childList.stream())
                                         .collect(Collectors.toList());
        System.out.println(result);
    }
}