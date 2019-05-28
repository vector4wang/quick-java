package com.feature.learn.codetimer;

/**
 * @author vector
 * @date: 2019/5/28 0028 16:31
 */
public class TestMain {
    public static void main(String[] args) {
        CodeTimer codeTimer1 = new CodeTimer();
        codeTimer1.start("fun1");
        fun1();
        codeTimer1.stop();


        CodeTimer codeTimer2 = new CodeTimer();
        codeTimer2.start("fun2");
        fun2();
        codeTimer2.stop();

        CodeTimer.prettyPrint();

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
