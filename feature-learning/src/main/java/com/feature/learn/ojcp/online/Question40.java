package com.feature.learn.ojcp.online;

/**
 *
 * @author wangxc
 * @date: 2019-11-13 14:36
 *
 */
public class Question40 {
	public static void main(String[] args) {
		A a = new A();
		AA aa = new AA();
		a = aa;
		System.out.println("a = " + a.getClass());
		System.out.println("aa = " + aa.getClass());

	}
}

class A {}
class AA extends A{}

interface ConstTest{
	public int A = 1; //1
	int B = 1;          //2
	static int C = 1;  //3
	final int D = 1; 	 //4
	public static int E = 1; //5
	public final int F = 1;  //6
	static final int G = 1;    //7
	public static final int H = 1; //8

	static void print() {
		System.out.println("123");
	}
}