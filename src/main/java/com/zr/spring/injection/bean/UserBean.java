package com.zr.spring.injection.bean;

public class UserBean {
	String name;
	String pwd;
	int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "UserBean{" +
				"name='" + name + '\'' +
				", pwd='" + pwd + '\'' +
				", age=" + age +
				'}';
	}
}
