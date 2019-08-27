package com.feature.learn.lambda.stream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public class FlatMapToDoubleExample {

    public static void main(String... args) {
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("1", "2"),
                Arrays.asList("5", "6"),
                Arrays.asList("3", "4")
        );

        DoubleStream dStream =
                listOfLists.stream().flatMapToDouble(childList ->
                        childList.stream()
                                 .mapToDouble(Double::new));
        //let's peek and find average of the elements
        OptionalDouble opt = dStream.peek(System.out::println)
                                    .average();
        if (opt.isPresent()) {
            System.out.println("average: " + opt.getAsDouble());
        }


    }
}