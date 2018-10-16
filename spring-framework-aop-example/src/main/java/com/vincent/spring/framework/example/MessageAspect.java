package com.vincent.spring.framework.example;

/**
 * Author: vincent
 * Date: 2018-10-16 09:40:00
 * Comment:
 */

public class MessageAspect {
    public void beforeAction() {
        System.out.println("before action");
    }

    public void afterAction() {
        System.out.println("after action");
    }
}
