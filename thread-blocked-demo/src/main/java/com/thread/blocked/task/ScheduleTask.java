package com.thread.blocked.task;

import com.thread.blocked.service.AsyncService;
import com.thread.blocked.service.SubThread;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

/**
 * @author vector
 * @date: 2019/7/31 0031 16:55
 */
@Component
public class ScheduleTask {

	@Resource
	private AsyncService asyncService;

	@PostConstruct
	public void doTask() {
		ScheduledExecutorService pool = new ScheduledThreadPoolExecutor(20,
				new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());
		for (int i = 0; i < 200; i++) {
			System.out.println("开始执行任务");
			pool.execute(() -> {
				Random random = new Random();
				int total = random.nextInt(100);
				System.out.println(Thread.currentThread().getName() + "---> 执行中...");
				for (int j = 0; j < total; j++) {
//					asyncService.doAsync();
					new SubThread().start();
				}
			});

		}
		pool.shutdown();
		try {
			while (!pool.awaitTermination(10, TimeUnit.SECONDS)) {
				System.out.println("等待线程池任务完毕执行！");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("任务执行完毕！！！");

	}
}
