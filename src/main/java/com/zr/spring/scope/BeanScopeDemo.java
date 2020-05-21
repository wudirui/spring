package com.zr.spring.scope;


import com.zr.spring.bean.UserBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

/**
 * bean的作用域
 */
public class BeanScopeDemo {

	/**
	 * 单例模式
	 *
	 * @return userBean
	 */
	@Bean(name = "singletonUser")
	public static UserBean singletonUserBean() {
		return createUserBean();
	}

	/**
	 * 多例模式
	 *
	 * @return UserBean
	 */
	@Bean(name = "prototypeUser")
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public static UserBean singleton() {
		return createUserBean();
	}

	@Autowired
	@Qualifier("singletonUser")
	private UserBean singletonUser;

	@Autowired
	@Qualifier("singletonUser")
	private UserBean singletonUser1;

	@Autowired
	@Qualifier("prototypeUser")
	private UserBean prototypeUser;

	@Autowired
	@Qualifier("prototypeUser")
	private UserBean prototypeUser1;

	@Autowired
	@Qualifier("prototypeUser")
	private UserBean prototypeUser2;


	private static UserBean createUserBean() {
		UserBean userBean = new UserBean();
		userBean.setAge(18);
		userBean.setName("无敌瑞");
		userBean.setPwd("123456");
		return userBean;

	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.registerBean(BeanScopeDemo.class);
		context.addBeanFactoryPostProcessor(beanFactory -> {
			beanFactory.addBeanPostProcessor(new BeanPostProcessor() {
				@Override
				public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
					System.out.printf("%s Bean 名称:%s 在初始化后回调...%n", bean.getClass().getName(), beanName);
					return bean;
				}
			});
		});
		context.refresh();

		// 通过依赖查找bean
		scopeBeanByLookup(context);

		//通过依赖注入
		scopeBeanByInject(context);
	}

	private static void scopeBeanByInject(AnnotationConfigApplicationContext context) {

	}

	private static void scopeBeanByLookup(AnnotationConfigApplicationContext context) {

	}
}
