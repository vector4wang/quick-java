package com.feature.learn.jvm;

/**
 *
 * 需要查看此类的字节码
 * @author vector
 * @date: 2019/10/12 0012 9:48
 */
public class ConstantPoolTest {
    final static int age = 10;
    public static void main(String[] args) {
        String name = "wxc";
        String first = new String("wang");
        System.out.println(name);
    }
}
