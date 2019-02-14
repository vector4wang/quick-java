package feature_learn.thread.java8CompletableFuture;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author vector
 * @date: 2019/2/14 0014 15:18
 */
public class BatchDateStreamProcess {
    public static void main(String[] args) {
        Random random = new Random();
        Stream<Integer> ints = random.ints(0, 100).limit(100).boxed();

        List<CompletableFuture<String>> collect = ints.map(integer -> CompletableFuture.supplyAsync(() -> integer * 3))
                .map(future -> future.thenApply(integer -> {
                    System.out.println("save " + integer + " to db");
                    return "ok";
                })).collect(Collectors.toList());


        List<String> list = collect.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
        System.out.println(list);

    }


}
