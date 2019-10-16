package com.feature.learn.ojcp;


/**
 *
 * @author wangxc
 * @date: 2019-10-14 23:19
 *
 */
public class Question35 {

}

abstract class Shape {
	private int x;
	private int y;

	public abstract void draw();

	public void setAccount(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

//class Circle implements Shape {
//}
abstract class Circle extends Shape {
	private int radix;
}

//abstract class Circle1 extends Shape {
//	private int radix;
//
//	public void draw() ;
//}

//abstract class Circle3 implements Shape{}

//public abstract class Cricle4 implements Shape {
//
//}