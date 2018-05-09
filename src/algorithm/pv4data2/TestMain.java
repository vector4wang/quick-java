package algorithm.pv4data2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wangxc
 * @GitHub: https://github.com/vector4wang
 * @CSDN: http://blog.csdn.net/qqhjqs?viewmode=contents
 * @BLOG: http://vector4wang.tk
 * @wxid: BMHJQS
 */
public class TestMain {

    public static void main(String[] args) {
        dealData();
    }


    private static void dealData() {
        Storage trade = new Storage();

        // 生产者 一个线程去读取
        Producer producer = new Producer(trade);
        Thread myReadThread = new Thread(producer);
        myReadThread.start();

        // 消费者 开了是个线程去处理数据
        Consumer consumer = new Consumer(trade);
        List<Thread> listThread = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread myThread = new Thread(consumer);
            myThread.start(); //启动线程
            listThread.add(myThread);
        }

        // 当所有线程任务完成就清除
        while (listThread.size() > 0) {
            Thread mythread = listThread.get(0);
            if ("TERMINATED".equals(mythread.getState().toString())) {
                listThread.remove(mythread);
            }
        }
    }
}
