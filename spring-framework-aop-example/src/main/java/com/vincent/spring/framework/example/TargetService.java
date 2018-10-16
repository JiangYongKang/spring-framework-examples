package com.vincent.spring.framework.example;

import org.springframework.stereotype.Component;

/**
 * Author: vincent
 * Date: 2018-10-15 17:08:00
 * Comment:
 */

@Component
public class TargetService {

    public void call() {
        System.out.println("target method");
    }

}
