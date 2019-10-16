package com.feature.learn.ojcp;

/**
 *
 * @author wangxc
 * @date: 2019-10-15 09:43
 *
 */
public class Question75 {
	public static void main(String[] args) {
		Employee e = new Employee ();
		System.out.print(e);
	}
}
class Employee {
	String name;
	boolean contract;
	double salary;
	Employee() {
//		name = "joe";
//		contract = true;
//		salary = 100;
		name = new String("joe");
		contract = new Boolean(true);
		salary = new Double(100);
	}
	public String toString() {
		return name + ":" + contract + ":" + salary;
	}

}