package com.feature.learn.lambda.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class NoneMatchExample {

    public static void main(String... args) {
        String[] array = {"one", "two", "three", "four"};

        Stream<String> stream = Arrays.stream(array);
        boolean b = stream.noneMatch(s -> s.startsWith("z"));
        System.out.println(b);

        Stream<String> stream2 = Arrays.stream(array);
        boolean b2 = stream2.noneMatch(s -> s.startsWith("f"));
        System.out.println(b2);
    }
}