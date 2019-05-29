package com.feature.learn.codetimer;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiFunction;

/**
 * @author vector
 * @date: 2019/5/28 0028 15:32
 */
public class CodeTimer {


    /**
     * 任务名
     */
    private String currentTaskName;

    /**
     * 同一个任务可能会被调用多次，每次用uuid区别
     */
    private String id;

    /**
     * 每次任务的状态集
     */
//    private Map<String, Boolean> subTaskStatus = new HashMap<>(10000);
    private boolean isStop = false;

    /**
     * 任务列表
     */
    private static Set<String> taskList = new HashSet<>();

    /**
     * subTask 与 name的映射map
     */
    private static Map<String, String> subTaskMap = new Hashtable<>();


    /**
     * 任务被调用次数
     */
    private static ConcurrentHashMap<String, Long> taskCallCountMap = new ConcurrentHashMap<>(8);

    /**
     * 任务执行时间
     */
    private static ConcurrentHashMap<String, Long> taskDurationMap = new ConcurrentHashMap<>(8);


    private long startTimeMillis;

    public synchronized void start(String taskName) {
        this.currentTaskName = taskName;
        this.startTimeMillis = System.currentTimeMillis();
        this.id = UUID.randomUUID().toString();
        taskList.add(this.currentTaskName);
        System.out.println(Thread.currentThread().getName() + " start");
        subTaskMap.put(this.id, this.currentTaskName);
    }

    public void stop() {
        if (isStop) {
            throw new IllegalStateException("Can't stop StopWatch: it's not running");
        }
        long lastTime = System.currentTimeMillis() - this.startTimeMillis;

        taskCallCountMap.merge(this.currentTaskName, 1L, (a, b) -> a + b); // awosome jdk 1.8 必须要使用ConcurrentHashMap
        taskDurationMap.merge(this.currentTaskName, lastTime, (a, b) -> a + b);
        isStop = true;
    }

    public static void prettyPrint() {
        for (String taskName : taskList) {
            System.out.println(taskName + " 被调用 " + taskCallCountMap.get(taskName) + "次，总耗时: " + taskDurationMap.get(taskName));
        }
        System.out.println("subTaskMap: " + subTaskMap.size());
        System.out.println("taskCallCountMap: " + taskCallCountMap);
    }

}
