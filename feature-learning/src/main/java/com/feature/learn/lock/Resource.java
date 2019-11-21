package com.feature.learn.lock;

class Resource {
	public synchronized void method1() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("method1 running...");
	}

	public synchronized void method2() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("method2 running...");
	}

	public synchronized static void method3() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("method3 running...");
	}

	public synchronized static void method4() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("method4 running...");
	}
}

//线程1-调用 synchronized方法
class Method1Thread extends Thread {

	private Resource syncMethodTest;

	public Method1Thread(Resource syncMethodTest) {
		this.syncMethodTest = syncMethodTest;
	}

	@Override
	public void run() {
		syncMethodTest.method1();
	}
}

//线程2-调用 synchronized方法
class Method2Thread extends Thread {

	private Resource resource;

	public Method2Thread(Resource syncMethodTest) {
		this.resource = syncMethodTest;
	}

	@Override
	public void run() {
		resource.method2();
	}
}

//线程3-调用 synchronized static方法
class Method3Thread extends Thread {

	private Resource syncMethodTest;

	public Method3Thread(Resource syncMethodTest) {
		this.syncMethodTest = syncMethodTest;
	}

	@Override
	public void run() {
		syncMethodTest.method3();
	}
}

//线程4-调用 synchronized static方法
class Method4Thread extends Thread {

	private Resource syncMethodTest;

	public Method4Thread(Resource syncMethodTest) {
		this.syncMethodTest = syncMethodTest;
	}

	@Override
	public void run() {
		syncMethodTest.method4();
	}
}