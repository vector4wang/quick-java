package com.feature.learn.jvm.objectsize.sample;

/**
 *
 * @author wangxc
 * @date: 2019-09-16 23:57
 *
 */
public class C {
	private int i;
	private char[] cc;

	public C() {
		i = 5;
		cc = new char[]{'a', 'b', 'c'};
	}

	public static void main(String[] args) throws InterruptedException {
		C c = new C();
		Thread.sleep(1000 * 1000);
		System.out.println(c);
	}
}
