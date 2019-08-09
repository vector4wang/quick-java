package com.feature.learn.thread.base;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author vector
 * @date: 2019/8/9 0009 17:29
 */
public class SuspendResumeTest {

    public static void main(String[] args) {
        try {
            //定义线程
            Thread t0 = new Thread() {
                @Override
                public void run() {
                    try {
                        for (long i = 0; i < 1000 * 1000 * 10; i++) {
                            System.out.println(i);
                        }
                        System.out.println("thread death");
                    } catch (Throwable ex) {
                        System.out.println("Caught in run: " + ex);
                        ex.printStackTrace();
                    }
                }
            };
            //开启线程
            t0.start();
            System.out.println("停一会");
            //等待2s之后挂起线程t0
            Thread.sleep(2 * 1000);
            //挂起线程
            t0.suspend();
            //打印当前的所有线程
//            printCurrentAliveThread();
            //等待2s之后恢复线程
            Thread.sleep(2 * 1000);
            //复活线程
            t0.resume();

        } catch (Throwable t) {
            System.out.println("Caught in main: " + t);
            t.printStackTrace();
        }

    }

    public static void printCurrentAliveThread() {
        Map<Thread, StackTraceElement[]> maps = Thread.getAllStackTraces();
        Set<Map.Entry<Thread, StackTraceElement[]>> set = maps.entrySet();
        Iterator<Map.Entry<Thread, StackTraceElement[]>> iterator = set.iterator();
        System.out.println("System Alive Thread List:");
        System.out.println("-------------------------");
        while (iterator.hasNext()) {
            System.out.println("AliveThread_Name:" + iterator.next().getKey().getName());
        }
        System.out.println("-------------------------");
    }

}
