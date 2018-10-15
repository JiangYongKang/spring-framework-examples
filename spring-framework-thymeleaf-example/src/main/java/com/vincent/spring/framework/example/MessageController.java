package com.vincent.spring.framework.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Author: MessageController
 * DateTime: 2018/10/14 23:02
 * Comment:
 */

@Controller
@RequestMapping("/messages")
public class MessageController {

    @GetMapping
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "Hello Thymeleaf");
        modelAndView.setViewName("messages/index");
        return modelAndView;
    }

}
