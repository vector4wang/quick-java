package com.thread.blocked.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author vector
 * @date: 2019/7/31 0031 16:58
 */
@Service
public class AsyncService {


    @Async(value = "asyncTaskExecutor")
    public void doAsync() {
        Random random = new Random();
        try {
            // 模拟耗时操作
            Thread.sleep(random.nextInt(3000));
            System.out.println(Thread.currentThread().getName() + " 执行中!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
