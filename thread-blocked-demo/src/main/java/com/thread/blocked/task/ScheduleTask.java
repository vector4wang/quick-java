package com.thread.blocked.task;

import com.thread.blocked.service.AsyncService;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ScheduledExecutorService pool = new ScheduledThreadPoolExecutor(20,
                new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());

        for (int i = 0; i < 200; i++) {
            System.out.println("开始执行任务");
            pool.execute(() -> {
                Random random = new Random();
                int total = random.nextInt(100);
                System.out.println(Thread.currentThread().getName() + "---> 执行中...");
                for (int j = 0; j < total; j++) {
                    asyncService.doAsync();
                }
            });

        }

        pool.shutdown();


        try {
            while (!pool.awaitTermination(10, TimeUnit.SECONDS)) {
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("任务执行完毕！！！");

    }
}
