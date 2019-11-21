package com.feature.learn.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 *
 * @author wangxc
 * @date: 2019-10-25 16:40
 *
 */
public class SemaphoreTest {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();

		final Semaphore semaphore = new Semaphore(5);
		for (int i = 0; i < 20; i++) {
			final int NO = i;
			Runnable run = ()->{
				try {
					semaphore.acquire();
					System.out.println("Accessing " + NO);
					Thread.sleep(10000);
					semaphore.release();
				} catch (Exception e) {
				}
			};
			executorService.execute(run);
		}

		executorService.shutdown();
	}
}
