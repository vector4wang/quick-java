package com.feature.learn.lambda.stream;

import java.util.stream.IntStream;

public class StatefulFixExample2 {
    public static void main (String[] args) {
        for (int i = 0; i < 5; i++) {
            process();
        }
    }

    private static void process () {
        IntStream stream = IntStream.range(1, 1000);

        //finding the even numbers
        int[] even = stream.parallel()
                           .filter(i -> i % 2 == 0)
                           .toArray();

        //finding sum
        int sum = IntStream.of(even).parallel().sum();

        System.out.printf("sum :%d  count:%d%n", sum, even.length);
    }
}