package com.feature.learn.thread.wait.multithread;

import com.feature.learn.thread.wait.onethread.TestThread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vector
 * @date: 2019/5/30 0030 15:44
 */
public class TestMain {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        List<Thread> list = new ArrayList<Thread>();
        for (int i = 0; i < 5; i++) {
            Thread thread = new TestThread();
            thread.start();
            list.add(thread);

            /**
             * 此种写法并不会让线程并行，在循环内，导致线程开始就必须等待死亡
             *  try {
             *      thread.join();
             *  } catch (InterruptedException e) {
             *      e.printStackTrace();
             *  }
             */
        }

        try {
            for (Thread thread : list) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        long end = System.currentTimeMillis();
        System.out.println("子线程执行时长：" + (end - start));

    }
}
