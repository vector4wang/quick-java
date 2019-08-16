package com.feature.learn.lambda.collectors;

import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 汇总信息
 */
public class SummarizingDoubleExample {
    public static void main(String[] args) {

        Stream<BigDecimal> s = Stream.iterate(
                BigDecimal.ONE, bigDecimal ->
                        bigDecimal.add(BigDecimal.ONE))
                .limit(10).peek(System.out::println);

        DoubleSummaryStatistics d = s.collect(Collectors.summarizingDouble
                (BigDecimal::doubleValue));
        System.out.println(d);
    }
}