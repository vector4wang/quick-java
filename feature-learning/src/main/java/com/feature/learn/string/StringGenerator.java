package com.feature.learn.string;

/**
 * @author vector
 * @date: 2018/12/28 0028 9:22
 * <p>
 * 通过查看源代码的方式比较String StringBuilder和StringBuffer的区别
 */
public class StringGenerator {

    public static void main(String[] args) {
        String string = "vector" + "wxc" + "test";

        String s = string + ".wxc";

        StringBuilder stringBuilder = new StringBuilder("vector");
        stringBuilder.append("1");
        stringBuilder.append("2");
        stringBuilder.append("3");
        System.out.println(stringBuilder.toString());

        StringBuffer stringBuffer = new StringBuffer("vector");
        stringBuffer.append("1");
        stringBuffer.append("2");
        stringBuffer.append("3");


    }


}
