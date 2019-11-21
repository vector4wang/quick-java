package com.feature.learn.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReenterLock implements Runnable {
	public static ReentrantLock lock = new ReentrantLock();
	public static int i = 0;

	public void run() {
		for (int j = 0; j < 100000; j++) {
			lock.lock();
			lock.lock();
			try {
				i++;
			} finally {
				lock.unlock();
				lock.unlock();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ReenterLock reenterLock = new ReenterLock();
		Thread t1 = new Thread(reenterLock);
		Thread t2 = new Thread(reenterLock);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(i);
	}
}