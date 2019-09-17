package com.feature.learn.jvm.objectsize.sample;

/**
 *
 * @author wangxc
 * @date: 2019-09-16 23:08
 *
 */
public class B {
	private int i = 5;
	private Integer ii = 128;

	public static void main(String[] args) throws InterruptedException {
		B b = new B();
		Thread.sleep(1000 * 1000);
		System.out.println(b);
	}
}
