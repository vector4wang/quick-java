package com.feature.learn.thread.collection;

import java.util.List;
import java.util.Random;

/**
 * @author vector
 * @date: 2019/8/13 0013 16:24
 */
public class WriterThread implements Runnable {

    private List<Integer> list;

    public WriterThread(List<Integer> list) {
        this.list = list;
    }


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" 正在写数据");
        list.add(new Random().nextInt(100));
    }
}
