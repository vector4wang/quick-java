package com.algorithm.pv4data2;

import java.util.ArrayList;
import java.util.List;

public class Storage {

    private List<String> cacheList; //工单数据列表
    public boolean readOK;

    /**
     * 默认构造函数
     */
    public Storage() {
        cacheList = new ArrayList<>();
        readOK = false;
    }


    /**
     * 进行资源生产
     */
    public synchronized void produce(List<String> listProducer) {
        while (cacheList.size() != 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("increace error: " + e.getMessage());
            }
        }
        if (listProducer.size() > 0) {
            this.cacheList.addAll(listProducer);
        } else {
            readOK = true; //没有往缓冲区中放数据，说明读取操作完成
        }
        System.out.println(readOK);
        this.notifyAll();
    }

    /**
     * 消费者进行资源消费
     */
    public synchronized String consume() {
        String result = null;
        while (cacheList.size() == 0) {
            if (!readOK) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("decreace error: " + e.getMessage());
                }
            } else {
                break;
            }
        }

        if (cacheList.size() > 0) {
            result = cacheList.remove(0);
        }
        this.notifyAll();
        return result;
    }
}