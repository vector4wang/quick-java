package com.feature.learn.concurrentcode;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author wangxc
 * @date: 2019-10-31 17:55
 *
 */
public class CountDownLatchTest {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(2);
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.execute(new BuyFoodTask(countDownLatch));
		executorService.execute(new BuyClothesTask(countDownLatch));
		countDownLatch.await();
		System.out.println(Thread.currentThread().getName() + " : 回家！");
		executorService.shutdown();
	}
}

class BuyClothesTask implements Runnable {

	private CountDownLatch countDownLatch;

	public BuyClothesTask(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(5000);
			System.out.println(Thread.currentThread().getName() + " : 我买好衣服了");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (countDownLatch != null) {
				countDownLatch.countDown();
			}
		}
	}
}

class BuyFoodTask implements Runnable {

	private CountDownLatch countDownLatch;

	public BuyFoodTask(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(3000);
			System.out.println(Thread.currentThread().getName() + "我买好东西了");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (this.countDownLatch != null) {
				this.countDownLatch.countDown();
			}
		}

	}
}