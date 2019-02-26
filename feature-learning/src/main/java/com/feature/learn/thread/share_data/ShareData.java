package com.feature.learn.thread.share_data;

/**
 * Created with IDEA
 * User: vector
 * Data: 2018/5/9 0009
 * Time: 19:52
 * Description:
 */
public class ShareData {

    public static void main(String[] args) {
        DataService ds = new DataService();

        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    ds.setData();
                }
            }).start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    ds.getData();
                }
            }).start();
        }
    }

}

class DataService {

    private int data;

    public synchronized void setData() {
        System.out.println("当前线程: " + Thread.currentThread().getName() + " : set before: " + data);
        data++;
        System.out.println("当前线程: " + Thread.currentThread().getName() + " : set after: " + data);
    }

    public synchronized void getData() {
        System.out.println("当前线程: " + Thread.currentThread().getName() + " : get before: " + data);
        data--;
        System.out.println("当前线程: " + Thread.currentThread().getName() + " : get after: " + data);
    }

}
