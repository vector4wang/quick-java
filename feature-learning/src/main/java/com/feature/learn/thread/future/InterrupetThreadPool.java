package com.feature.learn.thread.future;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class InterrupetThreadPool {

//	private static ThreadPoolTaskExecutor reqAnonymousPredictExecutor = new ThreadPoolTaskExecutor();
//
//	static {
//		reqAnonymousPredictExecutor.setCorePoolSize(20); // 核心线程数10：线程池创建时候初始化的线程数
//		reqAnonymousPredictExecutor.setMaxPoolSize(30); // 最大线程数20：线程池最大的线程数，只有在缓冲队列满了之后才会申请超过核心线程数的线程
//		reqAnonymousPredictExecutor.setQueueCapacity(200); // 缓冲队列200：用来缓冲执行任务的队列
//		reqAnonymousPredictExecutor.setKeepAliveSeconds(10); // 允许线程的空闲时间60秒：当超过了核心线程出之外的线程在空闲时间到达之后会被销毁
//		reqAnonymousPredictExecutor
//				.setThreadNamePrefix("reqAnonymousPredictExecutor-"); // 线程池名的前缀：设置好了之后可以方便我们定位处理任务所在的线程池
//		reqAnonymousPredictExecutor.initialize();

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		List<FutureTask<String>> futureTasks = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			FutureTask<String> stringFutureTask = new FutureTask<>(new DeadLineThread("word-" + i));


			futureTasks.add(stringFutureTask);


			executorService.submit(stringFutureTask);
		}

		for (FutureTask<String> futureTask : futureTasks) {
			if ("word-4".equals(futureTask.get())) {
				System.out.println("get the word and stop all thread!");
				executorService.shutdownNow();
				break;
			}
		}
	}
}


class DeadLineThread implements Callable<String> {

	private String word;

	public DeadLineThread(String word) {
		this.word = word;
	}

	@Override
	public String call() throws Exception {
		Thread.sleep(new Random().nextInt(5000));
		System.out.println(Thread.currentThread().getName() + " 正在执行");
		return word;
	}
}