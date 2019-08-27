package com.feature.learn.lambda.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class CollectExample2 {

    public static void main(String... args) {
        List<Integer> list = Arrays.asList(1, 3, 5, 11, 14);
        AtomicInteger result = list.stream().collect(sumCollector);
        System.out.println(result);
    }

    public static final Collector<Integer, AtomicInteger, AtomicInteger> sumCollector =
            new Collector<Integer, AtomicInteger, AtomicInteger>() {
                @Override
                public Supplier<AtomicInteger> supplier() {
                    return AtomicInteger::new;
                }

                @Override
                public BiConsumer<AtomicInteger, Integer> accumulator() {
                    return (a, i) -> {
                        a.set(a.get() + i);
                    };
                }

                @Override
                public BinaryOperator<AtomicInteger> combiner() {
                    return (a1, a2) -> {
                         AtomicInteger a = new AtomicInteger();
                         a.set(a1.get() + a2.get());
                         return a;
                    };
                }

                @Override
                public Function<AtomicInteger, AtomicInteger> finisher() {
                    return a -> a;
                }

                @Override
                public Set<Characteristics> characteristics() {
                    return Collections.emptySet();
                }
            };
}