package com.algorithm.union;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: wangxc
 * @GitHub: https://github.com/vector4wang
 * @CSDN: http://blog.csdn.net/qqhjqs?viewmode=contents
 * @BLOG: http://vector4wang.tk
 * @wxid: BMHJQS
 */
public class TestMain {


    /**
     * 大集合里分别有小集合，每个小集合里包含A或B或C集合
     * 要求经过相关算法处理之吼得到右边的集合
     *
     * 如果两个小集合包含同一个对象，如A或B则这个集合可以合并为{A,B,F}
     * {{A,B},{A,F},{B,C},{D}}--->{{A,B,F,C},{D}}
     */
    public static void main(String[] args) {
        List<String> temp1 = new ArrayList<>();
        temp1.add("A");
        temp1.add("B");
        List<String> temp2 = new ArrayList<>();
        temp2.add("A");
        temp2.add("F");
        List<String> temp3 = new ArrayList<>();
        temp3.add("C");
        temp3.add("B");
        List<String> temp4 = new ArrayList<>();
        temp4.add("D");

        List<List<String>> sourceList = new ArrayList<>();
        sourceList.add(temp1);
        sourceList.add(temp2);
        sourceList.add(temp3);
        sourceList.add(temp4);

        System.out.println(sourceList);

        for(int i=0;i<sourceList.size();i++) {
            List<String> stringsi = sourceList.get(i);
            for(int j=i+1;j<sourceList.size();j++) {
                List<String> stringsj = sourceList.get(j);
                if (isCanUnion(stringsi, stringsj)) {
                    unionList(stringsi,stringsj);
                }
            }
        }

        removeNullObj(sourceList);
        System.out.println(sourceList);
    }

    private static void removeNullObj(List<List<String>> sourceList) {
        Iterator<List<String>> iterator = sourceList.iterator();
        while (iterator.hasNext()) {
            List<String> next = iterator.next();
            if (next.size() <= 0) {
                iterator.remove();
            }

        }
    }

    private static void unionList(List<String> stringsi, List<String> stringsj) {
        Iterator<String> iterator = stringsi.iterator();
        while (iterator.hasNext()) {
            String temp = iterator.next();
            if (stringsj.contains(temp)) {
                iterator.remove();
            }
        }
        stringsi.addAll(stringsj);
        stringsj.clear();
    }

    private static boolean isCanUnion(List<String> stringsi, List<String> stringsj) {
        boolean canUnion = false;
        FLAG:for (String item : stringsi) {
            for (String subItem : stringsj) {
                if (item.equals(subItem)) {
                    canUnion = true;
                    break FLAG;
                }
            }
        }
        return canUnion;
    }
}
