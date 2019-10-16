package com.feature.learn.ojcp;

/**
 *
 * @author wangxc
 * @date: 2019-10-15 18:06
 *
 */
public class Question141 {
	public static void main(String[] args) {
		DoClass doClass = new DoClass();
	}
}

class DoClass implements DoInterface {
	int x1, x2;

	DoClass() {
		this.x1 = 0;
		this.x2 = 10;
	}

	public void m1(int p1) {
		x1 += p1;
		System.out.println(x1);
	}        // line n2

	public void m2(int p1) {
		x2 += p1;
		System.out.println(x2);
	}
}

interface DoInterface {
	void m1(int n);					// line n1
	public void m2(int n);
}