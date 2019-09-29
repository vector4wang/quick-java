package com.feature.learn.classloader;

/**
 * @author vector
 * @date: 2019/9/27 0027 9:16
 */
public class Test {
    static int i = 1;
    static {
        i = 0;
        System.out.println(i);
    }

    // static int i = 1; 放此处则会报错"非法向前引用"

}
