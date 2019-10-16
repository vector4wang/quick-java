package com.feature.learn.ojcp;

/**
 *
 * @author wangxc
 * @date: 2019-10-15 09:55
 *
 */
public class Question77 {
	public static void main(String[] args) {
		Sun obj2 = new Sun();
		Star obj3 = obj2;
		((Sun) obj3).doStuff();
		((Star) obj2).doStuff();
		((Universe) obj2).doStuff();
	}
}

class Star {
	public void doStuff() {
		System.out.println("Twinkling Star");
	}
}

interface Universe {
	public void doStuff();
}

class Sun extends Star implements Universe {
	public void doStuff() {
		System.out.println("Shining Sun");
	}
}

