package com.vincent.mq.example.test;

import com.vincent.mq.example.MessageSender;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Author: vincent
 * Date: 2019-07-24 21:53
 * Comment:
 */

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring-context-config.xml")
public class MessageSenderTest {

    @Resource
    private MessageSender messageSender;

    @After
    public void receiverTest() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
    }

    @Test
    public void sendTest() {
        messageSender.send("Hello World");
    }

}
