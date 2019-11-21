package com.feature.learn.lock;

public class StaticSynicTest {

	public static void main(String[] args) {
		Resource resource = new Resource();
		Resource resource1 = new Resource();
		//访问synchronized方法
		Thread t1 = new Method1Thread(resource);
		//访问synchronized方法
		Thread t2 = new Method2Thread(resource);
		//访问synchronized static方法
		Thread t3 = new Method3Thread(resource);
		//访问synchronized static方法
		Thread t4 = new Method4Thread(resource);
		//访问synchronized static方法
		Thread t6 = new Method4Thread(resource1);
		//访问synchronized 方法
		Thread t5 = new Method2Thread(resource1);
		/**
		 * 都是对同一个实例的synchronized域访问，因此不能被同时访问,
		 */
		        t1.start();
		        t2.start();
		/**
		 *是针对不同实例的，实例有两个,针对的不同的resource和resource1,因此可以同时被访问
		 */
//		        t1.start();
//		        t5.start();
		/**
		 *t1锁的是对象锁，t4锁的是Class锁。可以同时访问。
		 */
//		        t4.start();
//		        t1.start();
		/**
		 * t4和t6分别操作的资源不同，但是锁的是class锁，所以不可以同时访问
		 */
		        t4.run();
		        t6.run();
	}
}