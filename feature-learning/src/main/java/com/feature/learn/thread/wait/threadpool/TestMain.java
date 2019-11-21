package com.feature.learn.thread.wait.threadpool;

import com.feature.learn.thread.wait.onethread.TestThread;

import java.util.concurrent.*;

/**
 * 场景：一些任务开了线程池去处理，主线程需要在这些子线程完全执行完之后再去处理，就需要用到awaitTermination
 * @author vector
 * @date: 2019/5/30 0030 16:04
 */
public class TestMain {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

//        new new ThreadPoolExecutor(nThreads, nThreads,
//				0L, TimeUnit.MILLISECONDS,
//				new LinkedBlockingQueue<Runnable>());

        // 创建一个同时允许两个线程并发执行的线程池
        ExecutorService executor = Executors.newFixedThreadPool(5);
//        ExecutorService pool = new ThreadPoolExecutor(5, 200,
//                0L, TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 1000; i++) {
            Thread thread = new TestThread();
            executor.execute(thread);
        }
        executor.shutdown();

        try {
            // awaitTermination返回false即超时会继续循环，返回true即线程池中的线程执行完成主线程跳出循环往下执行，每隔10秒循环一次
            while (!executor.awaitTermination(10, TimeUnit.SECONDS)) ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("子线程执行时长：" + (end - start));
    }

}
