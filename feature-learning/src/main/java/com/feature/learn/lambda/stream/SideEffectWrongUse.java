package com.feature.learn.lambda.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class SideEffectWrongUse {

    public static void main (String[] args) {
        List<Integer> results = new ArrayList<>();
        IntStream.range(0, 150)
                 .parallel()
                 .filter(s -> s % 2 == 0)
                 .forEach(s -> results.add(s));//stateful side effect
        //not thread safe
        System.out.println(results);
    }
}