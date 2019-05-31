package com.feature.learn.thread.wait.onethread;

/**
 * @author vector
 * @date: 2019/5/30 0030 15:39
 */
public class TestMain {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Thread thread = new TestThread();
        thread.start();


        /**
         * 注意：join()要在start()方法之后调用。
         * 理解一下：此处是在主线程中，子线程执行join操作，join的注释为"Waits for this thread to die.",即主线程等待子线程死去
         */
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("子线程执行时长：" + (end - start));
    }
}
