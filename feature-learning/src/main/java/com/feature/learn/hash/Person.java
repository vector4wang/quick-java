package com.feature.learn.hash;

class Person {
	public int age;
	public String name;

	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}

	@Override
	public int hashCode() {
		return name.hashCode() + age;
	}
}