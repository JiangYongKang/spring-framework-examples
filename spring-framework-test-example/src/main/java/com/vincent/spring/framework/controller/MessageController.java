package com.vincent.spring.framework.controller;

import com.vincent.spring.framework.model.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: vincent
 * Date: 2018-10-25 11:16:00
 * Comment:
 */

@RestController
@RequestMapping("/messages")
public class MessageController {

    private ThreadLocal<List<Message>> messageContainer = new ThreadLocal<>();

    @PostConstruct
    public void initMessageContainer() {
        List<Message> messages = new ArrayList<>();
        messages.add(new Message("vincent", "this is test message"));
        messages.add(new Message("nick", "this is test message"));
        messageContainer.set(messages);
    }

    @GetMapping
    public ResponseEntity<?> index() {
        return ResponseEntity.ok(messageContainer.get());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Message message) {
        messageContainer.get().add(message);
        return ResponseEntity.ok(message);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<?> update(@PathVariable String uuid, @RequestBody Message message) {
        messageContainer.get().forEach(expiredMessage -> {
            if (expiredMessage.getUuid().equals(uuid)) {
                expiredMessage.setNickname(message.getNickname());
                expiredMessage.setContent(message.getContent());
                expiredMessage.setCreatedTime(message.getCreatedTime());
            }
        });
        return ResponseEntity.ok(message);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<?> delete(@PathVariable String uuid) {
        List<Message> messages = messageContainer.get();
        List<Message> afterMessages = messages.stream().filter(message -> !message.getUuid().equals(uuid))
                .collect(Collectors.toList());
        messageContainer.set(afterMessages);
        return ResponseEntity.ok("{\"uuid\":" + uuid + " }");
    }
}
