package com.feature.learn.ojcp.question89;

import java.util.ArrayList;

/**
 *
 * @author wangxc
 * @date: 2019-10-17 22:56
 *
 */
public class Question63 {
	public static void main(String[] args) {
		ArrayList<Integer> points = new ArrayList<>();
		points.add(1);
		points.add(2);
		points.add(3);
		points.add(4);
		points.add(5);
		points.add(null);
		points.remove(2);
		points.remove(null);
		System.out.println(points);
	}
}
