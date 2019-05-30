package com.feature.learn.thread.wait.onethread;

/**
 * @author vector
 * @date: 2019/5/30 0030 15:38
 */
public class TestThread extends Thread {

    @Override
    public void run() {
        System.out.println(this.getName() + "子线程开始");
        try {
            // 子线程休眠五秒
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName() + "子线程结束");
    }
}
