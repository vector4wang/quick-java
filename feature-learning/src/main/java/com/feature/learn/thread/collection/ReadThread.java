package com.feature.learn.thread.collection;

import java.util.List;

/**
 * @author vector
 * @date: 2019/8/13 0013 16:23
 */
public class ReadThread implements Runnable {

    private List<Integer> list;

    public ReadThread(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (Integer integer : list) {
            System.out.println(Thread.currentThread().getName() + " 正在读取list ->" + integer);
        }
    }
}
