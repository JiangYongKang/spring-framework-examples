package com.vincent.spring.framework.example.test;

import com.vincent.spring.framework.example.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Author: vincent
 * Date: 2018-10-16 09:42:00
 * Comment:
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class MessageAspectTests {

    @Resource
    private MessageService messageService;

    @Test
    public void aspectTest() {
        messageService.call();
    }

}
