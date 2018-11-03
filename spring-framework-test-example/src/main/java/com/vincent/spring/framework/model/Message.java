package com.vincent.spring.framework.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Message {

    private String uuid;
    private String nickname;
    private String content;
    private Date createTime;

    public Message(String nickname, String content) {
        this.uuid = UUID.randomUUID().toString().replace("-", "");
        this.nickname = nickname;
        this.content = content;
        this.createTime = new Date();
    }
}