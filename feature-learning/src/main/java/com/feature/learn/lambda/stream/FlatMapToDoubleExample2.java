package com.feature.learn.lambda.stream;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public class FlatMapToDoubleExample2 {

    public static void main(String... args) {

        String[][] arrayOfArrays = {{"1", "2"}, {"5", "6"}, {"3", "4"}};


        DoubleStream dStream = Arrays.stream(arrayOfArrays)
                                     .flatMapToDouble(childArray -> Arrays.stream(childArray)
                                                                          .mapToDouble(Double::new));
        OptionalDouble opt = dStream.peek(System.out::println)
                                    .average();
        if (opt.isPresent()) {
            System.out.println("average: " + opt.getAsDouble());
        }
    }
}