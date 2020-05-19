package com.zr.spring.injection.annotation;

import com.zr.spring.injection.bean.UserBean;
import com.zr.spring.injection.config.ConfigBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationInjectDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.registerBean(ConfigBean.class);
		context.refresh();
		UserBean userBean = context.getBean("userBean", UserBean.class);
		System.out.println(userBean);

	}

}
