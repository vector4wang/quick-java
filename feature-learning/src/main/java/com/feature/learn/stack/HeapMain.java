package com.feature.learn.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wangxc
 * @GitHub: https://github.com/vector4wang
 * @CSDN: http://blog.csdn.net/qqhjqs?viewmode=contents
 * @BLOG: http://vector4wang.tk
 * @wxid: BMHJQS
 * 所有对象的实例分配都在Java堆上分配内存，堆大小由-Xmx和-Xms来调节
 */
public class HeapMain {
    static class OOMObject{}
    public static void main(String[] args) throws InterruptedException {
        List<OOMObject> list = new ArrayList<OOMObject>();

        while(true){
//            Thread.sleep(10);
            list.add(new OOMObject());
        }
    }
}
