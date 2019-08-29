package com.feature.learn.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author vector
 * @date: 2019/8/29 0029 13:44
 */
public class HashMapTest {
    public static void main(String[] args) {
//        testBitOpera();
        testOverflow();
    }

    public static void testHashMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("abc", "123");
    }

    public static void testOverflow() {
//        int val = 10;
        int val = 9;
        for (int i = 0; i < 10; i++) {
            val = val * val;
            System.out.println(val + " : " + Integer.toBinaryString(val));
        }

        System.out.println(val);

    }

    /**
     * 位运算与直接乘的耗时比较
     */
    public static void testBitOpera() {
        int val = 29;
        long s = System.nanoTime();
        for (int i = 0; i < 100000000; i++) {
            int i1 = 29 * 31;
        }
        System.out.println(System.nanoTime() - s);
        s = System.nanoTime();
        for (int i = 0; i < 100000000; i++) {
            int i1 = (29 << 5) - 29;
        }
        System.out.println(System.nanoTime() - s);

    }
}
