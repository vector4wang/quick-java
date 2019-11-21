package com.feature.learn.lock;

import java.util.concurrent.locks.ReentrantLock;

public class FairLock implements Runnable {
	public static ReentrantLock fairLock = new ReentrantLock();

	public void run() {
		while (true) {
			try {
				fairLock.lock();
				System.out.println(Thread.currentThread().getName() + "，获得锁!");
			} finally {
				fairLock.unlock();
			}
		}
	}

	public static void main(String[] args) {
		FairLock fairLock = new FairLock();
		Thread t1 = new Thread(fairLock, "线程1");
		Thread t2 = new Thread(fairLock, "线程2");
		t1.start();
		t2.start();
	}
}