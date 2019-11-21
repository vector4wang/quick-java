package com.feature.learn.thread.join;

public class ThreadJoin {
	public static void main(String[] args) {
		Testjoin t = new Testjoin("a new  Thread");
		t.start();
		try {
			t.join();                     //等待被join线程执行完毕，也就是新线程执行完毕主线程才可以继续向下合并执行
		} catch (InterruptedException e) {
		}
		for (int i = 0; i < 10; i++) {
			System.out.println("i am main Thread");
		}
	}
}

class Testjoin extends Thread {
	public Testjoin(String s) {
		super(s); // 从父类继承的构造方法，得到线程的名字
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("i am" + getName());
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
		}
	}

}