package design_patterns.decorator;

/**
 * 装饰器模式
 * 接口作为一个装饰器变量
 */
public class TestMain {
	public static void main(String[] args) {
		JavaProgrammer javaProgrammer = new JavaProgrammer();
		javaProgrammer.coding();
		TestProgrammer testProgrammer = new TestProgrammer(javaProgrammer);
		testProgrammer.coding();
	}
}
