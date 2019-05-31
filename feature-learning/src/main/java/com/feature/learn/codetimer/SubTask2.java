package com.feature.learn.codetimer;

import java.util.concurrent.Callable;

/**
 * @author vector
 * @date: 2019/5/29 0029 16:19
 */
public class SubTask2 implements Callable<String> {

    @Override
    public String call() {
        CodeTimer2.start("fun3");
        fun3();
        CodeTimer2.stop("fun3");

        CodeTimer2.start("fun4");
        fun4();
        CodeTimer2.stop("fun4");

        return Thread.currentThread().getName() + ": fun3";
    }

    private void fun4() {
        System.out.println("do nothing");
    }

    private void fun3() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
