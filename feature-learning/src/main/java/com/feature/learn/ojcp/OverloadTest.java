package com.feature.learn.ojcp;

/**
 *
 * @author wangxc
 * @date: 2019-10-14 17:02
 *
 */
public class OverloadTest {
	public static void print() {
		System.out.println("Overloader");
	}
}

class SubClass extends OverloadTest {
	public static void print() {
		System.out.println("SubClass");
	}

	public static void main(String[] args) {
		OverloadTest overloadTest = new OverloadTest();
		overloadTest.print();
		OverloadTest subOverloader = new SubClass();
		subOverloader.print();
		SubClass subClass = new SubClass();
		subClass.print();


		StringBuilder sb = new StringBuilder ( ) ;
		sb.append ("world");
//		sb.append("hello", 1, 2); // 后面拼接
		sb.insert(0, "hello");// 只的是字符串的位置
		System.out.println(sb.toString());

	}
}
