package com.feature.learn.codetimer;


import java.util.concurrent.ConcurrentHashMap;

/**
 * 1、自身是线程安全的，在使用过程中会不会对原程序增加处理时间？
 * 2、如果对目标程序无法估计调用次数的话，会不会导致内存溢出？
 * 3、代码入侵的程度是否过高？
 *
 * @author vector
 * @date: 2019/5/28 0028 15:32
 */
public class CodeTimer {


    /**
     * 任务名
     */
    private String currentTaskName;


    /**
     * 任务被调用次数 线程安全
     */
    private static ConcurrentHashMap<String, Long> taskCallCountMap = new ConcurrentHashMap<>(8);

    /**
     * 任务执行时间 线程安全
     */
    private static ConcurrentHashMap<String, Long> taskDurationMap = new ConcurrentHashMap<>(8);


    private long startTimeMillis;

    public void start(String taskName) {
        this.currentTaskName = taskName;
        this.startTimeMillis = System.currentTimeMillis();
    }

    public void stop() {
        long lastTime = System.currentTimeMillis() - this.startTimeMillis;
        taskCallCountMap.merge(this.currentTaskName, 1L, (a, b) -> a + b);
        taskDurationMap.merge(this.currentTaskName, lastTime, (a, b) -> a + b);
    }

    public static void prettyPrint() {
        taskCallCountMap.forEach((k,v)->{
            System.out.println(k + " 被调用 " + v + "次，总耗时: " + taskDurationMap.get(k));
        });
        System.out.println("taskCallCountMap: " + taskCallCountMap);
    }

}
