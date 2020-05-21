package com.zr.spring.lifecycle;

import com.zr.spring.bean.LifecycleBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifecycleDemo {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF\\lifecycle-bean.xml");
        LifecycleBean lifecycle = context.getBean("lifecycle", LifecycleBean.class);
        lifecycle.getMessage();
        context.close();
    }
}
