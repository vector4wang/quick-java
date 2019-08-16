package com.feature.learn.lambda.collectors;

import java.math.BigDecimal;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AveragingIntExample {
    public static void main(String[] args) {
        Stream<BigDecimal> s = Stream.iterate(
                BigDecimal.ONE, bigDecimal ->
                        bigDecimal.add(BigDecimal.ONE))
                .limit(10).peek(System.out::println);

        Double d = s.collect(Collectors.averagingInt(BigDecimal::intValue));
        System.out.println("average: " + d);
    }
}