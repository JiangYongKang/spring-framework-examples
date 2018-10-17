package com.vincent.spring.framework.example;

import lombok.Data;

import java.util.Date;

/**
 * Author: Message
 * DateTime: 2018/10/13 8:59
 * Comment:
 */

@Data
public class Message {

    private Integer id;
    private String context;
    private Integer status;
    private Date createdAt;
    private Date updatedAt;

    public Message() {
    }

    public Message(String context) {
        this.context = context;
        this.setCreatedAt(new Date());
        this.setUpdatedAt(new Date());
    }
}
