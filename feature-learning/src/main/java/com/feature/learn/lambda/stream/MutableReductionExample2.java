package com.feature.learn.lambda.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MutableReductionExample2 {
    public static void main (String[] args) {
        IntStream stream = IntStream.range(1, 100);
        List<Integer> list = stream.parallel()
                                   .filter(i -> i % 10 == 0)
                                   .collect(ArrayList::new, ArrayList::add
                                                       , ArrayList::addAll);
        System.out.println(list);
    }
}