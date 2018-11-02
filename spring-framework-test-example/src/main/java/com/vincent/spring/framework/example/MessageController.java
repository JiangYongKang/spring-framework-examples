package com.vincent.spring.framework.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return ResponseEntity.ok("hello world");
    }
}
