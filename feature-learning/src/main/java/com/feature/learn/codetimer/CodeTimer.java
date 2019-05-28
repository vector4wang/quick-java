package com.feature.learn.codetimer;


import java.util.*;

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
    private Map<String, String> subTaskMap = new HashMap<>();


    /**
     * 任务被调用次数
     */
    private static Map<String, Integer> taskCallCountMap = new HashMap<>(8);

    /**
     *  任务执行时间
     */
    private static Map<String, Long> taskDurationMap = new HashMap<>(8);


    private long startTimeMillis;

    public void start(String taskName) {
        this.currentTaskName = taskName;
        this.startTimeMillis = System.currentTimeMillis();
        this.id = UUID.randomUUID().toString();
        taskList.add(this.currentTaskName);
//        subTaskStatus.put(this.id, true);
        subTaskMap.put(this.id, this.currentTaskName);
    }

    public void stop() {
        if (isStop) {
            throw new IllegalStateException("Can't stop StopWatch: it's not running");
        }
        long lastTime = System.currentTimeMillis() - this.startTimeMillis;
        Integer integer = taskCallCountMap.getOrDefault(this.currentTaskName,0);

        taskCallCountMap.put(this.currentTaskName, integer + 1);
        Long duration = taskDurationMap.getOrDefault(this.currentTaskName,0L);
        taskDurationMap.put(this.currentTaskName, duration + lastTime);
//        runningMap.put(id, false);
        isStop = true;
    }

    public static int getTaskCount() {
        return taskCallCountMap.size();
    }

    public static void prettyPrint() {
        for (String taskName : taskList) {
            System.out.println(taskName +" 被调用 " + taskCallCountMap.get(taskName) + "次，总耗时: "+ taskDurationMap.get(taskName));
        }
    }

}
