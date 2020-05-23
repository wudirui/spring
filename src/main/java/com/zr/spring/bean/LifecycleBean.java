package com.zr.spring.bean;

public class LifecycleBean {

    String message;

    public String getMessage() {
        System.out.println(message);
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void init() {
        System.out.println("LifecycleBean is going through init");
    }

    public void destroy() {
        System.out.println("LifecycleBean will destroy now");
    }
}
