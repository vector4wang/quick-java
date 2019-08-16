package com.feature.learn.lambda.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PartitioningByExample {
    public static void main(String[] args) {
        Map<Boolean, List<Long>> m = IntStream.range(1, 10)
                .mapToObj(Long::new)
                .collect(Collectors.partitioningBy(
                        i -> i % 2 == 0));
        System.out.println(m);

    }
}