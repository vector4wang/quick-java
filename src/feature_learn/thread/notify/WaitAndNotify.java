package feature_learn.thread.notify;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wangxc
 * @GitHub: https://github.com/vector4wang
 * @CSDN: http://blog.csdn.net/qqhjqs?viewmode=contents
 * @BLOG: http://vector4wang.tk
 * @wxid: BMHJQS
 *
 * notify唤醒一个等待的线程；notifyAll唤醒所有等待的线程
 * http://www.cnblogs.com/rongxh7/archive/2010/04/11/1709333.html
 *
 */
public class WaitAndNotify {
    public static void main(String[] args) {
        Object obj = new Object();

        System.out.println(obj);

        for (int i = 0; i < 5; i++) {
            MyThread t = new MyThread("Thread" + i, obj);
            t.start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println("-----Main Thread notify-----");
            synchronized (obj) {
                obj.notify();
//                obj.notifyAll();
            }

            TimeUnit.SECONDS.sleep(2);
            System.out.println("Main Thread is end.");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class MyThread extends Thread {
    private String name;
    private Object co;

    public MyThread(String name, Object o) {
        this.name = name;
        this.co = o;
    }

    @Override
    public void run() {
        System.out.println(name + " is waiting.");
        try {
            synchronized (co) {
                co.wait();
            }
            System.out.println(name + " has been notified.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
