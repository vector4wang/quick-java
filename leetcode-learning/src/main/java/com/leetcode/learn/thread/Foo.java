package com.leetcode.learn.thread;

/**
 * @author vector
 * @date: 2019/8/9 0009 16:10
 */
public class Foo {



    public static void main(String[] args) throws InterruptedException {
        Foo f = new Foo();

    }

    public static void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public static void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public static void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }


    public void one() {
        System.out.println("one");
    }
    public void two() {
        System.out.println("two");
    }
    public void three() {
        System.out.println("three");
    }
}
