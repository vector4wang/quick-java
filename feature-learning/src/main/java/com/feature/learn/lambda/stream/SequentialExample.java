package com.feature.learn.lambda.stream;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class SequentialExample {

    public static void main(String... args) {

        UnaryOperator<Integer> iterator = integer -> integer + 1;

        System.out.println("-- sequential ---");
        Stream.iterate(1, iterator)
              .limit(5)
              .sequential()
              .forEach(SequentialExample::process);

        System.out.println("-- parallel ---");
        Stream.iterate(1, iterator)
              .parallel()
              .limit(5)
              .forEach(SequentialExample::process);

    }

    private static void process(Integer integer) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(integer + " - " + LocalTime.now());
    }
}
