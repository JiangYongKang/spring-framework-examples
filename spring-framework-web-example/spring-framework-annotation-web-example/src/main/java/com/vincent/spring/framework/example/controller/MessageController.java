package com.vincent.spring.framework.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

/**
 * Author: vincent
 * Date: 2018-10-11 18:20:00
 * Comment:
 */

@Controller
@RequestMapping("/message")
public class MessageController {

    @GetMapping
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.addObject("uuid", UUID.randomUUID().toString().replace("-", ""));
        modelAndView.setViewName("/message/index");
        return modelAndView;
    }

}
