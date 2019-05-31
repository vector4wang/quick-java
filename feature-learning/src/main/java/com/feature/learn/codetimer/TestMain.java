package com.feature.learn.codetimer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author vector
 * @date: 2019/5/28 0028 16:31
 */
public class TestMain {

    private  static  ExecutorService fixedThreadPool = Executors.newFixedThreadPool(100);

    public static void main(String[] args) {
        CodeTimer codeTimer1 = new CodeTimer();
        codeTimer1.start("fun1");
        fun1();
        codeTimer1.stop();

        CodeTimer codeTimer2 = new CodeTimer();
        codeTimer2.start("fun2");
        fun2();
        codeTimer2.stop();

        List<FutureTask<String>> futureTaskList = new ArrayList<>();


        for (int i = 0; i <100 ; i++) {

            FutureTask<String> feature = new FutureTask<>(new SubTask());
            futureTaskList.add(feature);
            fixedThreadPool.submit(feature);
        }

        for (FutureTask<String> futureTask : futureTaskList) {
            try {
                System.out.println(futureTask.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        fixedThreadPool.shutdown();

        CodeTimer.prettyPrint();
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
