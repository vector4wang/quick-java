package com.feature.learn.map;

import java.util.HashMap;

/**
 * @author vector
 * @date: 2018/11/30 0030 9:25
 */
public class TestMain {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("A", "A1");
        map.put("B", "A2");
        map.put("C", "A3");
        map.put("D", "A4");
        map.put("E", "A5");

        map.containsKey("A");
        map.get("B");
        map.remove("C");
        map.hashCode();
        map.keySet();
    }
}
