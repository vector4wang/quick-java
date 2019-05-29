package com.feature.learn.codetimer;

import java.util.concurrent.Callable;

/**
 * @author vector
 * @date: 2019/5/29 0029 16:19
 */
public class SubTask implements Callable<String> {

    @Override
    public String call() {
        CodeTimer codeTimer3 = new CodeTimer();
        codeTimer3.start("fun3");
        fun3();
        codeTimer3.stop();
        return Thread.currentThread().getName() + ": fun3";
    }

    private void fun3() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
