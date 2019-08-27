package com.feature.learn.lambda.stream;

import java.util.stream.IntStream;

public class StatefulExample2 {
    private static int count = 0;

    public static void main (String[] args) {
        for (int i = 0; i < 5; i++) {
            process();
        }
    }

    private static void process () {
        count = 0;

        IntStream stream = IntStream.range(1, 1000);
        //finding the sum of even numbers
        int sum = stream.parallel()
                        .filter(i -> {
                            boolean b = i % 2 == 0;
                            if (b) {
                                count++;//updating count hence making it stateful.
                            }
                            return b;
                        })
                        .sum();

        System.out.printf("sum :%d  count:%d%n", sum, count);
    }
}