package com.design.patterns.proxy;

/**
 *
 * @author wangxc
 * @date: 2019-10-23 23:19
 *
 */
public class Reflect {
	public static void main(String[] args) {
		Fruit fruit = (Fruit) Dynamic.agent(Fruit.class, new Apple());
		fruit.smell();

	}
}
