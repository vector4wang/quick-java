package com.feature.learn.thread.wait.multithread;

import java.util.concurrent.CountDownLatch;

/**
 * @author vector
 * @date: 2019/5/30 0030 15:53
 */
public class TestThread extends Thread {

    private CountDownLatch countDownLatch;

    public TestThread(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + "子线程开始");
        try {
            // 子线程休眠五秒
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            // 如果子线程中会有异常，那么countDownLatch.countDown()应该写在finally里面，这样才能保证异常后也能对计数器减1，不会让主线程永远等待。
            System.out.println(this.getName() + "子线程结束");

            // 倒数器减1
            countDownLatch.countDown();
        }


    }
}
