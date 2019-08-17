package com.feature.learn.lambda.collectors;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToSetExample {
    public static void main (String[] args) {
        Stream<BigDecimal> s = Stream.iterate(
                            BigDecimal.ONE, bigDecimal ->
                                                bigDecimal.add(BigDecimal.ONE))
                                     .limit(10)
                                     .peek(System.out::println);

        Set<BigDecimal> l = s.collect(Collectors.toSet());
        System.out.println(l);
    }
}