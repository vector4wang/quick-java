package com.feature.learn.thread.synchronize;

/**
 *
 * @author wangxc
 * @date: 2019-10-25 19:20
 *
 */
public class NotifyDemo {

	public static void sleep(long sleepVal) {
		try {
			Thread.sleep(sleepVal);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void log(String desc) {
		System.out.println(Thread.currentThread().getName() + " : " + desc);
	}

	Object lock = new Object();

	public void startThreadA() {
		new Thread(() -> {
			synchronized (lock) {
				log("get lock");
				startThreadB();
				log("start wait");
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
//				try {
//					Thread.sleep(10000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
				log("get lock after wait");
				log("release lock");
			}
		}, "thread-A").start();
	}

	public void startThreadB() {
		new Thread(() -> {
			log("wait lock");
			synchronized (lock) {
				log("get lock");
				startThreadC();
				sleep(100);
				log("start notify");
				lock.notify();
				log("release lock");

			}
		}, "thread-B").start();
	}

	public void startThreadC() {
		new Thread(() -> {
			synchronized (lock) {
				log("get lock");
				log("release lock");
			}
		}, "thread-C").start();
	}

	public static void main(String[] args) {
		new NotifyDemo().startThreadA();
	}
}
