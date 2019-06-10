package com.feature.learn.cache;

/**
 * @author vector
 * @date: 2019/6/10 0010 9:19
 */
public class JavaIntegerCache {
    public static void main(String[] args) {
        Integer integer1 = 3;
        Integer integer2 = 3;

        if (integer1 == integer2)
            System.out.println("integer1 == integer2");
        else
            System.out.println("integer1 != integer2");

        Integer integer3 = 300;
        Integer integer4 = 300;

        if (integer3 == integer4)
            System.out.println("integer3 == integer4");
        else
            System.out.println("integer3 != integer4");


        /**
         * integer1 == integer2
         * integer3 != integer4
         */
    }
}
