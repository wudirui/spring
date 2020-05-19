package com.zr.spring.injection.annotation;

import com.zr.spring.injection.bean.UserBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ConfigBean {

	@Bean(name = "userBean")
	public UserBean userBean() {
		UserBean userBean = new UserBean();
		userBean.setName("无敌瑞");
		userBean.setPwd("123456");
		return userBean;
	}
}
