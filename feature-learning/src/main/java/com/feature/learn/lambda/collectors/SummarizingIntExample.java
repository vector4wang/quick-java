package com.feature.learn.lambda.collectors;

import java.math.BigDecimal;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SummarizingIntExample {
    public static void main(String[] args) {
        Stream<BigDecimal> s = Stream.iterate(
                BigDecimal.ONE, bigDecimal ->
                        bigDecimal.add(BigDecimal.ONE))
                .limit(10).peek(System.out::println);

        IntSummaryStatistics i = s.collect(Collectors.summarizingInt
                (BigDecimal::intValue));
        System.out.println(i);
    }
}