package com.feature.learn.ojcp.online;

/**
 *
 * @author wangxc
 * @date: 2019-10-17 15:46
 *
 */
public class Question5 {
	public static void main(String[] args) {
		Caller c = new Caller();
//		c.start();
//		c.init();

	}
}

class Caller {
	private void init() {
		System.out.println("Initialized");
	}

	private void start() {
		init();
		System.out.println("Started");
	}
}