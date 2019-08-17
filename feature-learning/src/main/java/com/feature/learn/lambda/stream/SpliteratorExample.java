package com.feature.learn.lambda.stream;

import java.util.Spliterator;
import java.util.stream.Stream;

public class SpliteratorExample {

    public static void main(String... args) {
        String[] stream = {"one", "two", "three", "four"};

        Spliterator<String> s1 = Stream.of(stream).spliterator();
        Spliterator<String> s2 = s1.trySplit();
        System.out.println("-- first Spliterator --");
        s1.forEachRemaining(System.out::println);
        System.out.println("-- second Spliterator --");
        s2.forEachRemaining(System.out::println);
    }
}