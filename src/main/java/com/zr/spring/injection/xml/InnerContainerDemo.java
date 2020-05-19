package com.zr.spring.injection.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * 内建容器
 */
public class InnerContainerDemo {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/inner-dependency-bean.xml");
		Environment environment = context.getBean(Environment.class);
		System.out.println("获取 Environment 类型的 Bean：" + environment);
	}
}
