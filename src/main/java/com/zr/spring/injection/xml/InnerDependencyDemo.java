package com.zr.spring.injection.xml;

import com.zr.spring.injection.repository.UserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 内建依赖
 */
public class InnerDependencyDemo {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/inner-dependency-bean.xml");
		UserRepository userRepository = context.getBean("userRepository", UserRepository.class);
		System.out.println(userRepository.getBeanFactory().getClass());
	}
}
