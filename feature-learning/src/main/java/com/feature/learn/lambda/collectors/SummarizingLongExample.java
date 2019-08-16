package com.feature.learn.lambda.collectors;

import java.math.BigDecimal;
import java.util.LongSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SummarizingLongExample {
    public static void main(String[] args) {

        Stream<BigDecimal> s = Stream.iterate(
                BigDecimal.ONE, bigDecimal ->
                        bigDecimal.add(BigDecimal.ONE))
                .limit(10).peek(System.out::println);

        LongSummaryStatistics l = s.collect(Collectors.summarizingLong
                (BigDecimal::longValue));
        System.out.println(l);
    }
}