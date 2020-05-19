package com.zr.spring.lookup;

import com.zr.spring.bean.UserBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class DependencyLookup {
	public static void main(String[] args) {

		BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/user-bean.xml");

		// 按照类型查找
		lookupByType(beanFactory);
		// 按照类型查找结合对象
		lookupCollectionByType(beanFactory);
		// 通过注解查找对象
		lookupByAnnotationType(beanFactory);

		lookupInRealTime(beanFactory);

		lookupInLazy(beanFactory);


	}

	/**
	 * 懒加载
	 *
	 * @param beanFactory
	 */
	private static void lookupInLazy(BeanFactory beanFactory) {
		ObjectFactory<UserBean> objectFactory = (ObjectFactory<UserBean>) beanFactory.getBean("objectFactory");
		UserBean user = objectFactory.getObject();
		System.out.println("延迟查找：" + user);
	}

	/**
	 * 实时查找
	 *
	 * @param beanFactory
	 */
	private static void lookupInRealTime(BeanFactory beanFactory) {
		UserBean user = (UserBean) beanFactory.getBean("user");
		System.out.println(user);
	}

	private static void lookupByAnnotationType(BeanFactory beanFactory) {
		if (beanFactory instanceof ListableBeanFactory) {
			ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
			Map<String, Object> beans = listableBeanFactory.getBeansWithAnnotation(Bean.class);
			System.out.println(beans);
		}
	}

	/**
	 * 按照类型查找所有的对象
	 *
	 * @param beanFactory
	 */
	private static void lookupCollectionByType(BeanFactory beanFactory) {
		if (beanFactory instanceof ListableBeanFactory) {
			ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
			Map<String, UserBean> userBeans = listableBeanFactory.getBeansOfType(UserBean.class);
			System.out.println("查找所有的 user集合对象" + userBeans);
		}
	}

	/**
	 * 按照类型查找
	 *
	 * @param beanFactory
	 */
	private static void lookupByType(BeanFactory beanFactory) {
		UserBean bean = beanFactory.getBean(UserBean.class);
		System.out.println(bean);
	}
}
