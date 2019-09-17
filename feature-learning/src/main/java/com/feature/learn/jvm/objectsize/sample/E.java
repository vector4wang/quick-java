package com.feature.learn.jvm.objectsize.sample;

/**
 * @author vector
 * @date: 2019/9/17 0017 13:54
 */
public class E {
    private String string;

    public E() {
        string = "abcde";
    }

    public static void main(String[] args) throws InterruptedException {
        E e = new E();
        Thread.sleep(1000 * 1000);
        System.out.println(e);
    }
}
