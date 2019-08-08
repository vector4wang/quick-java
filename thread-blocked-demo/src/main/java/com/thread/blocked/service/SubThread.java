package com.thread.blocked.service;

import java.util.Random;

/**
 *
 * @author wangxc
 * @date: 2019-08-04 22:01
 *
 */
public class SubThread extends Thread {

	@Override
	public void run() {
		Random random = new Random();
		// 模拟耗时操作
		try {
			Thread.sleep(random.nextInt(3000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " 执行中!");
	}
}
