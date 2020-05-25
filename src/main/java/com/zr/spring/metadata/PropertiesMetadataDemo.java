package com.zr.spring.metadata;

import com.zr.spring.bean.UserBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

@PropertySource("classpath:/META-INF/user-bean.properties")
public class PropertiesMetadataDemo {
    @Bean(name = "userBean")
    public UserBean userBean(@Value("${userBean.name}") String name, @Value("${userBean.pwd}") String pwd) {
        UserBean userBean = new UserBean();
        userBean.setName(name);
        userBean.setPwd(pwd);
        return userBean;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        Map<String, Object> propertiesSource = new HashMap<>();
        propertiesSource.put("userBean.name", "zhangrui2");
        org.springframework.core.env.PropertySource propertySource = new MapPropertySource("first-property-source", propertiesSource);
        context.getEnvironment().getPropertySources().addFirst(propertySource);
        // 注册当前类作为 Configuration Class
        context.register(PropertiesMetadataDemo.class);
        // 启动 Spring 应用上下文
        context.refresh();
        // beanName 和 bean 映射
        Map<String, UserBean> usersMap = context.getBeansOfType(UserBean.class);
        for (Map.Entry<String, UserBean> entry : usersMap.entrySet()) {
            System.out.printf("User Bean name : %s , content : %s \n", entry.getKey(), entry.getValue());
        }
        System.out.println(context.getEnvironment().getPropertySources());
        // 关闭 Spring 应用上下文
        context.close();
    }
}
