package com.feature.learn.thread.base;

/**
 * @author vector
 * @date: 2019/8/9 0009 17:56
 */
public class SuspendResumeTest2 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println(123);
            Thread.currentThread().suspend();
            System.out.println(456);
        }, "sub-thread-");

        thread.start();

        System.out.println("主线程对子线程控制");
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        thread.join();
        thread.resume();
    }
}
