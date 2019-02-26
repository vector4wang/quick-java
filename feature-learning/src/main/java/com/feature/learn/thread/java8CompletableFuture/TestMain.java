package com.feature.learn.thread.java8CompletableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * @author vector
 * @date: 2019/2/14 0014 14:03
 * <p>
 * https://blog.csdn.net/mrxiky/article/details/78962614
 */
public class TestMain {
    public static void main(String[] args) {
        thenApply();
        thenAccept();
        thenRun();
        thenCombine();
        applyToEither();
        acceptEither();
        runAfterEither();
        exceptionally();
        whenComplete();
        handle();
    }

    private static void handle() {
        /**
         * 运行完成时，对结果的处理。这里的完成时有两种情况，一种是正常执行，返回值。另外一种是遇到异常抛出造成程序的中断。
         * public <U> CompletionStage<U> handle(BiFunction<? super T, Throwable, ? extends U> fn);
         * public <U> CompletionStage<U> handleAsync(BiFunction<? super T, Throwable, ? extends U> fn);
         * public <U> CompletionStage<U> handleAsync(BiFunction<? super T, Throwable, ? extends U> fn,Executor executor);
         */
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 出现异常
//            if (1 == 1) {
//                throw new RuntimeException("异常");
//            }
            return "s1";
        }).handle((s, t) -> {
            if (t != null) {
                return "hello error world";
            }
            return s;
        }).join();
        System.out.println(result);
    }

    private static void whenComplete() {
        /**
         * 当运行完成时，对结果的记录。这里的完成时有两种情况，一种是正常执行，返回值。另外一种是遇到异常抛出造成程序的中断。
         * 这里为什么要说成记录，因为这几个方法都会返回CompletableFuture，
         * 当Action执行完毕后它的结果返回原始的CompletableFuture的计算结果或者返回异常。所以不会对结果产生任何的作用。
         *
         * public CompletionStage<T> whenComplete(BiConsumer<? super T, ? super Throwable> action);
         * public CompletionStage<T> whenCompleteAsync(BiConsumer<? super T, ? super Throwable> action);
         * public CompletionStage<T> whenCompleteAsync(BiConsumer<? super T, ? super Throwable> action,Executor executor);
         */
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (1 == 1) {
                throw new RuntimeException("出现异常1");
            }
            return "s1";
        }).whenComplete((s, t) -> {
            System.out.println(s);
            System.out.println(t.getMessage());

        }).exceptionally(e -> {
            System.out.println(e.getMessage());
            return "Hello Error World!";
        }).join();
        System.out.println(result);

    }

    private static void exceptionally() {
        /**
         * 当运行时出现了异常，可以通过exceptionally进行补偿。
         * public CompletionStage<T> exceptionally(Function<Throwable, ? extends T> fn);
         */
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (1 == 1) {
                throw new RuntimeException("出现异常");
            }
            return "s1";
        }).exceptionally(e -> {
            System.out.println(e.getMessage());
            return "Hello Error World ";
        }).join();
        System.out.println(result);
    }

    private static void runAfterEither() {
        /**
         * 两个CompletionStage，任何一个完成了都会执行下一步的操作（Runnable）。
         * public CompletionStage<Void> runAfterEither(CompletionStage<?> other,Runnable action);
         * public CompletionStage<Void> runAfterEitherAsync(CompletionStage<?> other,Runnable action);
         * public CompletionStage<Void> runAfterEitherAsync(CompletionStage<?> other,Runnable action,Executor executor);
         */
        CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "s1";
        }).runAfterEither(CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "s2";

        }), () -> System.out.println("hello world!"));
        while (true) {
        }

    }

    private static void acceptEither() {
        /**
         * 两个CompletionStage，谁计算的快，我就用那个CompletionStage的结果进行下一步的消耗操作。
         * public CompletionStage<Void> acceptEither(CompletionStage<? extends T> other,Consumer<? super T> action);
         * public CompletionStage<Void> acceptEitherAsync(CompletionStage<? extends T> other,Consumer<? super T> action);
         * public CompletionStage<Void> acceptEitherAsync(CompletionStage<? extends T> other,Consumer<? super T> action,Executor executor);
         */
        CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "s1";
        }).acceptEither(CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello World";
        }), System.out::println);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void applyToEither() {
        /**
         * 两个CompletionStage，谁计算的快，我就用那个CompletionStage的结果进行下一步的**转化**操作。
         * public <U> CompletionStage<U> applyToEither(CompletionStage<? extends T> other,Function<? super T, U> fn);
         * public <U> CompletionStage<U> applyToEitherAsync(CompletionStage<? extends T> other,Function<? super T, U> fn);
         * public <U> CompletionStage<U> applyToEitherAsync(CompletionStage<? extends T> other,Function<? super T, U> fn,Executor executor);
         */
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "s1";
        }).applyToEither(CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello World!";
        }), s -> s).join();
        System.out.println(result);

    }

    private static void thenCombine() {
        /**
         * 结合两个CompletionStage的结果，进行转化后返回
         * public <U,V> CompletionStage<V> thenCombine(CompletionStage<? extends U> other,BiFunction<? super T,? super U,? extends V> fn);
         * public <U,V> CompletionStage<V> thenCombineAsync(CompletionStage<? extends U> other,BiFunction<? super T,? super U,? extends V> fn);
         * public <U,V> CompletionStage<V> thenCombineAsync(CompletionStage<? extends U> other,BiFunction<? super T,? super U,? extends V> fn,Executor executor);
         */
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "world!";
        }), (s1, s2) -> s1 + " " + s2).join();
        System.out.println(result);
    }

    private static void thenRun() {
        /**
         * 对上一步的计算结果不关心，执行下一个操作。
         * public CompletionStage<Void> thenRun(Runnable action);
         * public CompletionStage<Void> thenRunAsync(Runnable action);
         * public CompletionStage<Void> thenRunAsync(Runnable action,Executor executor);
         */
        CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello";
        }).thenRun(() -> System.out.println("hello world!"));
        while (true) {
        }
    }

    private static void thenAccept() {
        /**
         * 进行消耗
         * public CompletionStage<Void> thenAccept(Consumer<? super T> action);
         * public CompletionStage<Void> thenAcceptAsync(Consumer<? super T> action);
         * public CompletionStage<Void> thenAcceptAsync(Consumer<? super T> action,Executor executor);
         */
        CompletableFuture.supplyAsync(() -> "Hello").thenAccept(s -> System.out.println(s + " World !"));
    }

    private static void thenApply() {
        /**
         * 进行变换
         * public <U> CompletionStage<U> thenApply(Function<? super T,? extends U> fn);
         * public <U> CompletionStage<U> thenApplyAsync(Function<? super T,? extends U> fn);
         * public <U> CompletionStage<U> thenApplyAsync(Function<? super T,? extends U> fn,Executor executor);
         */
        String result = CompletableFuture.supplyAsync(() -> "hello").thenApply(s -> s + " world !").join();
        System.out.println(result);
    }
}
