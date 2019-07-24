package com.vincent.spring.framework.example;

import lombok.extern.java.Log;

/**
 * Author: vincent
 * Date: 2018-10-16 09:40:00
 * Comment:
 */

@Log
public class MessageAspect {
    public void beforeAction() {
        log.info("before action");
    }

    public void afterAction() {
        log.info("after action");
    }
}
