package com.zr.spring.bean;

/**
 * 懒加载实例
 */
public class Duck {
    public Duck() {
        System.out.println("============duck 诞生了==============");
    }

    public void behavior() {
        System.out.println("鸭子水上漂");
    }
}
