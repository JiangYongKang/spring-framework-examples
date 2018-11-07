package com.vincent.spring.framework.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Author: vincent
 * DateTime: 2018/11/7 23:48
 * Comment:
 */

public class TestQuartzJob {

    public void run() {
        System.out.println("Hello Quartz " + new Date());
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-content.xml");
    }

}
