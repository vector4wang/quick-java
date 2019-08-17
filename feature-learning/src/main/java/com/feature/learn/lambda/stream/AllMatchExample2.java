package com.feature.learn.lambda.stream;

import java.util.ArrayList;

/**
 * An empty stream will return true
 */
public class AllMatchExample2 {

    public static void main(String... args) {
        boolean b = new ArrayList<>().stream()
                                     .allMatch(e -> false);
        System.out.println(b);
    }
}