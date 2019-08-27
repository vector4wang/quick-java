package com.feature.learn.lambda.stream;

import java.util.stream.Stream;

public class CloseExample {

    public static void main(String... args) {
        Stream<String> stream = Stream.of("one", "two", "three", "four");
        stream.forEach(System.out::println);
        //it's not necessary
        stream.close();
    }
}