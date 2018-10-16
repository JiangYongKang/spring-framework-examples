package com.vincent.spring.framework.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Author: vincent
 * Date: 2018-10-15 17:16:00
 * Comment:
 */

public class TestSpringAop {
    public static void main(String[] args) {
        ApplicationContext application = new AnnotationConfigApplicationContext("com.vincent.spring.framework.example");
        application.getBean(TargetService.class).call();
    }
}
