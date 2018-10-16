package com.vincent.spring.framework.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Author: vincent
 * Date: 2018-10-12 09:30:00
 * Comment:
 */

@Aspect
@Component
public class AopComponent {

    @Before("execution(* com.vincent.spring.framework.example.*.*(..))")
    public void beforeAction(JoinPoint joinPoint) {
        System.out.println("before action");
    }
}
