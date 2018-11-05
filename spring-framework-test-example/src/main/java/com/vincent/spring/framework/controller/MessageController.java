package com.vincent.spring.framework.controller;

import com.vincent.spring.framework.model.Message;
import com.vincent.spring.framework.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Author: vincent
 * Date: 2018-10-25 11:16:00
 * Comment:
 */

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Resource
    private MessageService messageService;

    @GetMapping
    public ResponseEntity<?> index() {
        return ResponseEntity.ok(messageService.index());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Message message) {
        messageService.create(message);
        return ResponseEntity.ok(message);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<?> update(@PathVariable String uuid, @RequestBody Message message) {
        message.setUuid(uuid);
        messageService.update(message);
        return ResponseEntity.ok(message);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<?> delete(@PathVariable String uuid) {
        messageService.destroy(uuid);
        return ResponseEntity.ok(uuid);
    }
}
