package com.zr.spring.injection.xml;

import com.zr.spring.injection.bean.UserBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 通过配置文件实现ioc，依赖来源自定义bean
 */
public class DependencyInjectionDemo {
	public static void main(String[] args) {
		//1.获取spring上下文配置文件
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/userBean.xml");
		//2.获取对象,依赖的来源 自定义bean
		UserBean user = context.getBean("user", UserBean.class);
		System.out.println(user);
	}

}
