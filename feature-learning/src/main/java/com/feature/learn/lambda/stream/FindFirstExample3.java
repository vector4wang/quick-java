package com.feature.learn.lambda.stream;

import java.util.Optional;
import java.util.stream.Stream;

public class FindFirstExample3 {

    public static void main(String... args) {
        Stream<String> s = Stream.of("one", "two", "three", "four");
        Optional<String> opt = s.parallel()
                                .findFirst();
        if (opt.isPresent()) {
            System.out.println(opt.get());
        }
    }
}