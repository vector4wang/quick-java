package com.feature.learn.thread.priority;

/**
 *
 * @author wangxc
 * @date: 2019-10-22 09:40
 *
 */
public class PriorityTest {
	public static void main(String[] args) {
		Thread t1 = new Thread(()-> System.out.println(Thread.currentThread().getName()),"t1");
		Thread t2 = new Thread(()-> System.out.println(Thread.currentThread().getName()),"t2");
		t2.setPriority(Thread.MAX_PRIORITY);
		t1.setPriority(Thread.MIN_PRIORITY);


		t1.start();
		t2.start();
	}
}
