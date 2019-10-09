package com.feature.learn.classloader;

/**
 * @author vector
 * @date: 2019/10/9 0009 9:32
 */
public class ParentLoaderTest {
    public static void main(String[] args) {
        System.out.println(ParentLoaderTest.class.getClassLoader());
        System.out.println(ParentLoaderTest.class.getClassLoader().getParent());
        System.out.println(ParentLoaderTest.class.getClassLoader().getParent().getParent());
    }
}
