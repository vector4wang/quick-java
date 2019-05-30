package com.feature.learn.codetimer;

import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * 单线程直接用start和stop即可
 * 多线程或线程池需根据对应的结束方式join or awaitTermination
 * @author vector
 * @date: 2019/5/30 0030 14:38
 */
public class CodeTimer2 {
    /**
     * 任务名
     */
    private static ThreadLocal<String> currentTaskName = new ThreadLocal<>();


    /**
     * 任务被调用次数 线程安全
     */
    private static ConcurrentHashMap<String, Long> taskCallCountMap = new ConcurrentHashMap<>(8);

    /**
     * 任务执行时间 线程安全
     */
    private static ConcurrentHashMap<String, Long> taskDurationMap = new ConcurrentHashMap<>(8);


    private static ThreadLocal<Long> startTimeMillis = new ThreadLocal<>();

    public static void start(String taskName) {
        System.out.println(Thread.currentThread().getName() + " ---> " + taskName);
        currentTaskName.set(taskName);
        startTimeMillis.set(System.currentTimeMillis());
    }

    public static void stop() {

        long lastTime = System.currentTimeMillis() - startTimeMillis.get();
        taskCallCountMap.merge(currentTaskName.get(), 1L, (a, b) -> a + b);
        taskDurationMap.merge(currentTaskName.get(), lastTime, (a, b) -> a + b);
    }

    public static void prettyPrint() {
        taskCallCountMap.forEach((k, v) -> {
            System.out.println(k + " 被调用 " + v + "次，总耗时: " + taskDurationMap.get(k));
        });
        System.out.println("taskCallCountMap: " + taskCallCountMap);
    }
}
