package com.vincent.spring.framework.example;

import lombok.Data;

import java.util.Date;

/**
 * Author: Message
 * DateTime: 2018/10/14 21:06
 * Comment:
 */

@Data
public class Message {

    private Integer id;
    private String content;
    private Boolean status;
    private Date createdAt;
    private Date updatedAt;

}
