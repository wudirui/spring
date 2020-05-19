package com.zr.spring.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.zr.spring.bean.UserBean;

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

//        lookupInRealTime(beanFactory);
//        lookupInLazy(beanFactory);


	}

	private static void lookupByAnnotationType(BeanFactory beanFactory) {
		if (beanFactory instanceof ListableBeanFactory) {
			ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
			//listableBeanFactory.getBeansWithAnnotation("".getClass());
		}
	}

	/**/
	private static void lookupCollectionByType(BeanFactory beanFactory) {
		if (beanFactory instanceof ListableBeanFactory) {
			ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
			Map<String, UserBean> userBeans = listableBeanFactory.getBeansOfType(UserBean.class);
			System.out.println("查找所有的 user集合对象" + userBeans);
		}
	}

	private static void lookupByType(BeanFactory beanFactory) {
		UserBean bean = beanFactory.getBean(UserBean.class);
		System.out.println(bean);
	}
}
