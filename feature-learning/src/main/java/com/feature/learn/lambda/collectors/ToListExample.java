package com.feature.learn.lambda.collectors;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToListExample {
    public static void main (String[] args) {
        Stream<BigDecimal> s = Stream.iterate(
                            BigDecimal.ONE, bigDecimal ->
                                                bigDecimal.add(BigDecimal.ONE))
                                     .limit(10)
                                     .peek(System.out::println);

        List<BigDecimal> l = s.collect(Collectors.toList());
        System.out.println(l);
    }
}