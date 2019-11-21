package com.feature.learn.utils;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
	private final CyclicBarrier barrier;
	private final Worker[] workers;

	public CyclicBarrierTest() {
		int count = Runtime.getRuntime().availableProcessors();
		this.barrier = new CyclicBarrier(count, () -> System.out.println("所有线程均到达栅栏位置，开始下一轮计算"));
		this.workers = new Worker[count];
		for (int i = 0; i < count; i++) {
			workers[i] = new Worker(i);
		}
	}

	private class Worker implements Runnable {
		int i;

		public Worker(int i) {
			this.i = i;
		}

		@Override
		public void run() {
			for (int index = 1; index < 3; index++) {
				System.out.println("线程" + i + "第" + index + "次到达栅栏位置，等待其他线程到达");
				try {
					//注意是await,而不是wait
					barrier.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
					return;
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
					return;
				}
			}
		}

	}

	public void start() {
		for (int i = 0; i < workers.length; i++) {
			new Thread(workers[i]).start();
		}
	}

	public static void main(String[] args) {
		new CyclicBarrierTest().start();
	}
}