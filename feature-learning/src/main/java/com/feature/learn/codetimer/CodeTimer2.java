package com.feature.learn.codetimer;

import java.util.Hashtable;
import java.util.Map;
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
    private static ThreadLocal<Map<String,Long>> currentTaskName = new ThreadLocal<>();

    /**
     * 任务被调用次数 线程安全
     */
    private static ConcurrentHashMap<String, Long> taskCallCountMap = new ConcurrentHashMap<>(8);

    /**
     * 任务执行时间 线程安全
     */
    private static ConcurrentHashMap<String, Long> taskDurationMap = new ConcurrentHashMap<>(8);


    public synchronized static void start(String taskName) {

        Map<String, Long> stringLongMap = currentTaskName.get();
        if (stringLongMap == null) {
            stringLongMap = new Hashtable<>();
        }
        if (stringLongMap.containsKey(taskName)) {
            throw new IllegalStateException("Cant't start: it's already running");
        }
        stringLongMap.put(taskName, System.currentTimeMillis());
        currentTaskName.set(stringLongMap);
    }

    public static void stop(String taskName) {
        Map<String, Long> nameTimeMap = currentTaskName.get();
        if (!nameTimeMap.containsKey(taskName)) {
            throw new IllegalStateException("Cant't stop: it's already stopped");
        }
        Long startTime = nameTimeMap.remove(taskName);
        long lastTime = System.currentTimeMillis() - startTime;
        taskCallCountMap.merge(taskName, 1L, (a, b) -> a + b);
        taskDurationMap.merge(taskName, lastTime, (a, b) -> a + b);
    }

    public static void prettyPrint() {
//        taskCallCountMap.forEach((k, v) -> {
//            System.out.println("【" + k + "】被调用【" + v + "】次，总耗时：" + taskDurationMap.get(k) + "ms 平均耗时：" + taskDurationMap.get(k) / v +"ms");
//        });
//
        System.out.println(getPrettyPrint());
    }

    public static String getPrettyPrint() {
        StringBuilder sb = new StringBuilder();
        sb.append("--------------------------------------------------\n");
        sb.append("TaskName  \n");
        sb.append("CallTotal   TotalDuration(ms)   Ave(ms)  \n");
        sb.append("--------------------------------------------------\n");
        taskCallCountMap.forEach((k, v) -> {
            sb.append(String.format("%s \n%d  %10d(ms) %10d(ms)", k, v, taskDurationMap.get(k), taskDurationMap.get(k) / v)).append("\n");
            sb.append("--------------------------------------------------\n");
        });
        return sb.toString();
    }
}
