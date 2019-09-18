package com.feature.learn.jvm.objectsize;

/**
 * @author vector
 * @date: 2019/9/6 0006 9:37
 */
public class TestMain {
    public static void main(String[] args) {
        /**
         * java中强制类型转换时，高位数截取成低位数的方法
         * 233: 00000000 00000000 00000000 11101001
         * int 4字节 32 位
         * byte 1字节 8位
         * 去低八位 11101001
         * 最高位位1 即为负数
         */
        byte b1 = (byte) 233;

        System.out.println((byte) 129);
        System.out.println((byte) -129);
        System.out.println("~b2: " + ~10);


        float af = 1f;
        float bf = 0.9f;

        float ff = af - bf;

        System.out.println(ff);

        byte s1 = 127;
        s1 = (byte) (s1 + 1);
        System.out.println("s1: " + s1);

        s1 += 1;

        System.out.println(s1);


    }
}
