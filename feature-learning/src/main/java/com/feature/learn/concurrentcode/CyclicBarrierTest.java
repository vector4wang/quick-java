package com.feature.learn.concurrentcode;

import java.util.concurrent.*;

/**
 *https://www.jianshu.com/p/4ef4bbf01811
 * @author wangxc
 * @date: 2019-10-31 19:47
 *
 */
public class CyclicBarrierTest {
	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(4, new TourGuideTask());
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		executorService.execute(new TravelTask(cyclicBarrier, "A", 5));
		executorService.execute(new TravelTask(cyclicBarrier, "B", 2));
		executorService.execute(new TravelTask(cyclicBarrier, "C", 3));
		executorService.execute(new TravelTask(cyclicBarrier, "D", 1));
		executorService.shutdown();
	}
}

class TravelTask implements Runnable {

	private CyclicBarrier cyclicBarrier;
	private String name;
	private int arriveTime;

	public TravelTask(CyclicBarrier cyclicBarrier, String name, int arriveTime) {
		this.cyclicBarrier = cyclicBarrier;
		this.name = name;
		this.arriveTime = arriveTime;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(3000);
			System.out.println(name + " 到达集合点");
			cyclicBarrier.await();
			System.out.println(name + " 坐飞机了");
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}

	}
}

class TourGuideTask implements Runnable {

	@Override
	public void run() {
		System.out.println("都来了，发护照！");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}