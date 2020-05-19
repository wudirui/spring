package com.zr.spring.repository;

import com.zr.spring.bean.UserBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class UserRepository {

	//自定义依赖
	private List<UserBean> userBeanList;

	//内建依赖
	private BeanFactory beanFactory;

	//内建依赖
	private ObjectFactory<ApplicationContext> objectFactories;



	public List<UserBean> getUserBeanList() {
		return userBeanList;
	}

	public void setUserBeanList(List<UserBean> userBeanList) {
		this.userBeanList = userBeanList;
	}

	public BeanFactory getBeanFactory() {
		return beanFactory;
	}

	public void setBeanFactory(BeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}

	public ObjectFactory<ApplicationContext> getObjectFactories() {
		return objectFactories;
	}

	public void setObjectFactories(ObjectFactory<ApplicationContext> objectFactories) {
		this.objectFactories = objectFactories;
	}
	@Override
	public String toString() {
		return "UserRepository{" +
				"userBeanList=" + userBeanList +
				", beanFactory=" + beanFactory +
				", objectFactories=" + objectFactories +
				'}';
	}
}
