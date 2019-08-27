package com.feature.learn.lambda.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample4 {

    public static void main(String... args) {
        String[][] arrayOfStringArrays = {{"one", "two"}, {"five", "six"}, {"three", "four"}};
        List<String> result = Arrays.stream(arrayOfStringArrays)
                                    .flatMap(childArray -> Arrays.stream(childArray))
                                    .collect(Collectors.toList());
        System.out.println(result);
    }


}