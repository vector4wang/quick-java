package com.feature.learn.concurrentcode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author wangxc
 * @date: 2019-10-29 20:14
 *
 */
public class AtomicTest {

	private static AtomicInteger count = new AtomicInteger(0);
//	private static int count ;

	public static void increment() {
		count.incrementAndGet();
//		count++;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			new Thread(()->{
				for (int j = 0; j < 10000; j++) {
					increment();
				}
			}).start();
		}

		while (Thread.activeCount() > 1) {
			Thread.yield();
		}
		System.out.println(count);


	}
}
