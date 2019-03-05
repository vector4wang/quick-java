package com.design.patterns.decorator;

/**
 * 装饰器模式
 * 接口作为一个装饰器变量
 */
public class TestMain {
	public static void main(String[] args) {
		JavaProgrammer javaProgrammer = new JavaProgrammer();
		javaProgrammer.coding();
		System.out.println("================");
		DeployProgrammer deployProgrammer = new DeployProgrammer(new TestProgrammer(javaProgrammer));
		deployProgrammer.coding();
	}
}
