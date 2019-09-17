package com.feature.learn.jvm.objectsize.sample;

public class Test {
	public static void main(String[] args) throws InterruptedException {
		TestObject testObject = new TestObject();
		Thread.sleep(600 * 1000);
		System.out.println(testObject);
	}
}

class TestObject {
	private int i;
	private double d;
	private char[] c;

	public TestObject() {
		this.i = 1;
		this.d = 1.0;
		this.c = new char[]{'a', 'b', 'c'};
	}
}