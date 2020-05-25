package com.zr.spring.bean;

/**
 * 非懒加载实例
 */
public class Dog {

    public Dog() {
        System.out.println("========Dog 诞生了========");
    }
    public void behavior() {
        System.out.println("狗会叫：旺旺");
    }
}
