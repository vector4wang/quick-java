package com.feature.learn.lambda.stream;

import java.util.Iterator;
import java.util.stream.Stream;

public class IteratorExample {


    public static void main(String... args) {
        Stream<String> s = Stream.of("one", "two", "three", "four");
        Iterator<String> iterator = s.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
    }
}