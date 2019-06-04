package com.feature.learn.codetimer;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author vector
 * @date: 2019/5/28 0028 16:31
 */
public class TestMain2 {

    private  static  ExecutorService fixedThreadPool = Executors.newFixedThreadPool(100);

    public static void main(String[] args) {
        CodeTimer2.start("fun1");
        fun1();
        CodeTimer2.stop("fun1");

        CodeTimer2.start("fun2");
        fun2();
        CodeTimer2.stop("fun2");


        for (int i = 0; i <100 ; i++) {

            fixedThreadPool.execute(()->{
                CodeTimer2.start("fun3");
                fun3();
                CodeTimer2.stop("fun3");


                CodeTimer2.start("fun4");
                fun4();
                CodeTimer2.stop("fun4");
            });
        }

        fixedThreadPool.shutdown();

        try {
            // awaitTermination返回false即超时会继续循环，返回true即线程池中的线程执行完成主线程跳出循环往下执行，每隔10秒循环一次
            while (!fixedThreadPool.awaitTermination(10, TimeUnit.SECONDS));
        } catch (Exception e) {
            e.printStackTrace();
        }
        /**
         * testcase:
         * fun1 被调用 1次，总耗时: 2001
         * fun2 被调用 1次，总耗时: 1001
         * fun3 被调用 100次，总耗时: 50335
         * taskCallCountMap: {fun1=1, fun2=1, fun3=100}
         */

        CodeTimer2.prettyPrint();
    }

    private static void fun4() {
        System.out.println("do nothing");
        CodeTimer2.start("fun5");
        fun5();
        CodeTimer2.stop("fun5");
    }

    private static void fun5() {
        try {
            int val = new Random().nextInt(1000);
            System.out.println("fun5: " + val);
            Thread.sleep(val);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void fun3() {
        try {
            System.out.println(Thread.currentThread().getName() + ": fun3");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void fun2() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void fun1() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
