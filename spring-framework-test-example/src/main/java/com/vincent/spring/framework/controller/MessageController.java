package com.vincent.spring.framework.controller;

import com.vincent.spring.framework.model.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Author: vincent
 * Date: 2018-10-25 11:16:00
 * Comment:
 */

@RestController
@RequestMapping("/messages")
public class MessageController {

    @GetMapping
    public ResponseEntity<?> index() {
        List<Message> messages = new ArrayList<>();
        messages.add(new Message("vincent", "hello", new Date()));
        messages.add(new Message("vincent", "world", new Date()));
        return ResponseEntity.ok(messages);
    }
}
