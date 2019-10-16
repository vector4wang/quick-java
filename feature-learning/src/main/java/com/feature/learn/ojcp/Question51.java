package com.feature.learn.ojcp;

/**
 *
 * @author wangxc
 * @date: 2019-10-15 08:23
 *
 * 父类中的静态变量不会被子类覆盖
 */
public class Question51 {
	public static void main(String[] args) {
		Base b1 = new DerivedB();
		Base b2 = new DerivedA();
		Base b3 = new DerivedB();
		b1.test();
		b2.test();
		b3.test();
		System.out.println("===============");
		b1 = (Base) b3;
		Base b4 = (DerivedA) b3;
		b1.test();
		b4.test();
	}
}

class Base {
	public void test() {
		System.out.println("Base ");
	}
}

class DerivedA extends Base {
	public void test() {
		System.out.println("DerivedA ");
	}
}

class DerivedB extends DerivedA {
	public void test() {
		System.out.println("DerivedB ");
	}

}