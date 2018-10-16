package com.vincent.spring.framework.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Author: MessageController
 * DateTime: 2018/10/14 21:09
 * Comment:
 */

@Controller
@RequestMapping("/messages")
public class MessageController {

    @Resource
    private MessageDao messageDao;

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("messages", messageDao.findAll());
        modelAndView.setViewName("/messages/index");
        return modelAndView;
    }

}
