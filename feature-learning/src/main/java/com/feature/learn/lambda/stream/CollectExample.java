package com.feature.learn.lambda.stream;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class CollectExample {

    public static void main(String... args) {
        List<Integer> list = Arrays.asList(1, 3, 5, 11, 14);

        Supplier<AtomicInteger> supplier = AtomicInteger::new;

        BiConsumer<AtomicInteger, Integer> accumulator =
                (AtomicInteger a, Integer i) -> {
                    a.set(a.get() + i);
                };

        BiConsumer<AtomicInteger, AtomicInteger> combiner =
                (a1, a2) -> {
                    a1.set(a1.get() + a2.get());
                };

        AtomicInteger result = list.stream()
                                   .collect(supplier, accumulator, combiner);
        System.out.println(result);
    }
}