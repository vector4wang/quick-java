package com.feature.learn.thread.wait.multithread;

import java.util.concurrent.CountDownLatch;

/**
 * @author vector
 * @date: 2019/5/30 0030 15:52
 */
public class TestMain4CountDownLatch {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        // 创建一个初始值为5的倒数计数器
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            Thread thread = new TestThread(countDownLatch);
            thread.start();
        }

        try {
            // 阻塞当前（main）线程，直到倒数计数器倒数到0
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("子线程执行时长：" + (end - start));
    }
}
