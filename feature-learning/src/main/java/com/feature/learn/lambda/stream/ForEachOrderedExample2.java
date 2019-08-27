package com.feature.learn.lambda.stream;

import java.util.stream.Stream;

public class ForEachOrderedExample2 {
    public static void main(String... args) {
        String[] s = {"one", "two", "three", "four"};
        runForEach(Stream.of(s).parallel());
        runForEachOrdered(Stream.of(s).parallel());
    }

    private static void runForEach(Stream<String> stream) {
        System.out.println("-- running unordered --");
        stream.forEach(System.out::println);
    }

    private static void runForEachOrdered(Stream<String> stream) {
        System.out.println("-- running ordered --");
        stream.forEachOrdered(System.out::println);
    }
}