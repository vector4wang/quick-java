package com.feature.learn.jvm;

/**
 * @author vector
 * @date: 2019/10/11 0011 17:00
 */
public class IntegerReference {
    public static void main(String[] args) {
        Integer i = 250;
        change(i);
        System.out.println(i);
    }

    public static void change(Integer integer) {
        integer = 251;
    }
}
