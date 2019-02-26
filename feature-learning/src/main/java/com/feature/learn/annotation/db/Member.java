package com.feature.learn.annotation.db;

@DBTable(name="member")
public class Member {
	@SQLString(30)
	String firstName;

	@SQLString(50)
	String lastName;

	@SQLInteger
	Integer age;

	@SQLString(value = 30, constraints = @Constraints(primaryKey = true))
	String handle;

	static int count;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getHandle() {
		return handle;
	}

	public void setHandle(String handle) {
		this.handle = handle;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Member.count = count;
	}
}
