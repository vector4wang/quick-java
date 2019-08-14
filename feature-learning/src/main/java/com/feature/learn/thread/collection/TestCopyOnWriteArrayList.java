package com.feature.learn.thread.collection;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author vector
 * @date: 2019/8/13 0013 16:23
 */
public class TestCopyOnWriteArrayList {

    public static void main(String[] args) {
        //1、初始化CopyOnWriteArrayList
        List<Integer> tempList = Arrays.asList(new Integer [] {1,2});
        CopyOnWriteArrayList<Integer> copyList = new CopyOnWriteArrayList<>(tempList);


        //2、模拟多线程对list进行读和写
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new ReadThread(copyList));
        executorService.execute(new WriterThread(copyList));
        executorService.execute(new WriterThread(copyList));
        executorService.execute(new WriterThread(copyList));
        executorService.execute(new ReadThread(copyList));
        executorService.execute(new WriterThread(copyList));
        executorService.execute(new ReadThread(copyList));
        executorService.execute(new WriterThread(copyList));

        System.out.println("copyList size:" + copyList.size());

        executorService.shutdown();
    }
}
