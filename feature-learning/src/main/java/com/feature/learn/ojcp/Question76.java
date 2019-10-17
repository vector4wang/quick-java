package com.feature.learn.ojcp;

/**
 *
 * @author wangxc
 * @date: 2019-10-17 22:04
 *
 */
public class Question76 {
	static double area = 0;
	int b = 2, h = 3;

	public static void main(String[] args) {
		double p, b, h; //line n1
		if (area == 0) {
			b = 3;
			h = 4;
			p = 0.5;
		}
//		area = p * b * h; //line n2
		System.out.println("Area is " + area);
	}
}
