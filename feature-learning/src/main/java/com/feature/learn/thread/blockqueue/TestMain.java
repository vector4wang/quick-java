package com.feature.learn.thread.blockqueue;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 线程安全队列LinkedBlockingQueue 在多线程放消息与多线程取消息，如何才能最安全即不会重复消费
 */
public class TestMain {

	public static LinkedBlockingQueue<String> queue = new LinkedBlockingQueue();

	public static void main(String[] args) {

		Thread p1 = new Thread(new Producer("p1"));
		Thread p2 = new Thread(new Producer("p2"));
		Thread p3 = new Thread(new Producer("p3"));
		Thread p4 = new Thread(new Producer("p4"));

		Thread c1 = new Thread(new Consumer("c1"));
		Thread c2 = new Thread(new Consumer("c2"));
		Thread c3 = new Thread(new Consumer("c3"));
		Thread c4 = new Thread(new Consumer("c4"));
		Thread c5 = new Thread(new Consumer("c5"));
		Thread c6 = new Thread(new Consumer("c6"));
		Thread c7 = new Thread(new Consumer("c7"));





		p1.start();
		p2.start();
		p3.start();
		p4.start();

		c1.start();
		c2.start();
		c3.start();
		c4.start();
		c5.start();
		c6.start();
		c7.start();

	}

	public static String getRandomString(int length) {
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(62);
			sb.append(str.charAt(number));
		}
		return sb.toString();
	}
}

class Producer implements Runnable {

	private String threadName;

	public Producer(String threadName) {
		this.threadName = threadName;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String msg = TestMain.getRandomString(7);
			TestMain.queue.add(msg);
			System.out.println(threadName + " 产生消息: " + msg);
		}

	}
}

class Consumer implements Runnable {

	private String threadName;

	public Consumer(String threadName) {
		this.threadName = threadName;
	}

	@Override
	public void run() {
		try {
			while (true) {
				Thread.sleep(5000);
				String msg = TestMain.queue.take();
				System.out.println(threadName + "消费: " + msg);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	}
}