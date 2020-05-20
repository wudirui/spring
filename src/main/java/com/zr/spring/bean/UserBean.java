package com.zr.spring.bean;

import org.springframework.core.io.Resource;

import java.util.List;
import java.util.Properties;

public class UserBean {
	String name;
	String pwd;
	int age;
	private City city;
	private City[] workCities;
	private List<City> lifeCities;

	private Resource configFileLocation;

	private Company company;

	private Properties context;

	private String contextAsText;

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
