package com.feature.learn.lambda.stream;

import java.util.Arrays;
import java.util.List;

public class AllMatchExample {

    public static void main(String... args) {
        List<Integer> list = Arrays.asList(2, 4, 6, 8);
        boolean b = list.stream().allMatch(i -> i % 2 == 0);
        System.out.println(b);
    }
}