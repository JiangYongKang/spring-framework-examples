package com.vincent.spring.framework.example;

import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

/**
 * User: vincent
 * Date: 2017/7/19
 * Comment: @Component 注解表明该类会作为一个组件类，并告知 Spring 要为这个类创建组件
 */

@Log
@Component
public class CDPlayerComponent {

    public String play() {
        log.info("start play...");
        return "Hello Spring Beans";
    }

}
