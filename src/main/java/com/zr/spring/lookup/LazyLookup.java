package com.zr.spring.lookup;

import com.zr.spring.bean.Dog;
import com.zr.spring.bean.DuckBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 懒加载和非懒加载实例
 */
public class LazyLookup {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF\\lazy-bean.xml");
        System.out.println("======在实例调用之前======");
        DuckBean duck = (DuckBean) context.getBean("duck");
        duck.behavior();
        Dog dog = (Dog) context.getBean("dog");
        dog.behavior();
    }
}
