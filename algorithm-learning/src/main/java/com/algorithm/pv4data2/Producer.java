package com.algorithm.pv4data2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Producer implements Runnable {

    private Storage manage;
    private int readSize;
    private int totalReadSize = 0;

    /**
     * 默认构造函数
     */
    public Producer(Storage trade) {
        manage = trade;
        readSize = 0;
        totalReadSize = 0;
    }

    public void run() {
        do {
            manage.produce(this.readData(50000));
        } while (readSize > 0);
    }

    public static String getRandomString(int length) { //length表示生成字符串的长度
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 进行数据读取
     *
     * @param readCount 读取的数据量
     * @return 返回读取的数据数
     */
    public List<String> readData(int readCount) {
        List<String> result = new ArrayList<>();
        Random random = new Random();
        int size = random.nextInt(100);
        System.out.println("数据size： " + size);
        for (int i = 0; i < size; i++) {
            result.add(getRandomString(10));
        }

        readSize = result.size(); //获取读取的数量
        if (readSize > 0) {
            totalReadSize += readSize;
            System.out.println("read size: " + readSize + " total read size: " + totalReadSize);
            System.out.println("read ok.");
        }
        return result;

    }
}