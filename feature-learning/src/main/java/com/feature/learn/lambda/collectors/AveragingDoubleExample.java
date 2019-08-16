package com.feature.learn.lambda.collectors;

import java.math.BigDecimal;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 返回双精度运算符的算术平均值
 */
public class AveragingDoubleExample {
    public static void main(String[] args) {
        Stream<BigDecimal> s = Stream.iterate(
                BigDecimal.ONE, bigDecimal ->
                        bigDecimal.add(BigDecimal.ONE))
                .limit(10).peek(System.out::println);

        Double d = s.collect(Collectors.averagingDouble(BigDecimal::doubleValue));
        System.out.println("average: " + d);
    }
}