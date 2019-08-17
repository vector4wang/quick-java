package com.feature.learn.lambda.stream;

import java.util.Optional;
import java.util.stream.Stream;

public class FindAnyExample {

    public static void main(String... args) {
        Stream<String> s = Stream.of("one", "two", "three", "four");
        Optional<String> optionalString = s.findAny();
        if(optionalString.isPresent()){
            System.out.println(optionalString.get());
        }
    }
}