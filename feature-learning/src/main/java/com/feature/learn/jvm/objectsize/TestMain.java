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

        System.out.println((byte)233); // -23
        System.out.println((byte)-233); // 23
		System.out.println("~b2: " + ~10); // -11


        float af = 1f;
        float bf = 0.9f;

        float ff = af-bf;

        System.out.println(ff);


        short  s1 = 1;
//        s1 = s1 + 1;

        s1 += 1;

        System.out.println(s1);

//
//        byte b = 1;
//        Byte bb = 1;
//
//        char c = 1;
//        Character bc = 1;
//
//        short s = 1;
//        Short bs = 1;
//
//        int i = 1;
//        Integer bi = 1;
//
//
//        double d = 1;
//        Double bd = 1D;
//
//        float f = 1;
//        Float bf = 1F;
//
//        long l = 1;
//        Long bl = 1L;
//
//        boolean bn = false;
//        Boolean bbn = false;




    }
}
