package com.vincent.spring.framework.example;

import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * author: vincent
 * date: 2019-05-05 00:04
 * comment: 一个简单的 controller，主要用于演示如何通过 Spring mvc 构建 web 服务
 */

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

    @GetMapping
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("OS_NAME", System.getProperty("os.name"));
        modelAndView.addObject("OS_VERSION", System.getProperty("os.version"));
        modelAndView.addObject("JAVA_HOME", System.getProperty("java.home"));
        modelAndView.addObject("JAVA_VERSION", System.getProperty("java.version"));
        modelAndView.addObject("SPRING_VERSION", SpringVersion.getVersion());
        modelAndView.setViewName("/welcome");
        return modelAndView;
    }

}
