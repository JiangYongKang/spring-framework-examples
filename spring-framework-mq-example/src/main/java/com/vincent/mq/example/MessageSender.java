package com.vincent.mq.example;

import org.springframework.jms.core.JmsTemplate;

/**
 * Author: vincent
 * Date: 2019-07-24 21:48
 * Comment:
 */

public class MessageSender {

    private JmsTemplate template;

    public MessageSender(JmsTemplate template) {
        this.template = template;
    }

    public void send(String text) {
        template.convertAndSend(text);
    }
}
