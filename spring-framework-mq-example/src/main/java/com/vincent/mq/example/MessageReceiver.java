package com.vincent.mq.example;

import lombok.extern.slf4j.Slf4j;

import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Author: vincent
 * Date: 2019-07-24 21:50
 * Comment:
 */

@Slf4j
public class MessageReceiver implements MessageListener {
    @Override
    public void onMessage(Message message) {
        log.info("接受到消息: {}", message);
    }
}
