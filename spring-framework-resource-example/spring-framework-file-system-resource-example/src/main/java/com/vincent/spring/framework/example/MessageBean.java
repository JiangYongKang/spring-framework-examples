package com.vincent.spring.framework.example;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

/**
 * Author: vincent
 * Date: 2018-10-15 17:33:00
 * Comment:
 */

@Data
@NoArgsConstructor
public class MessageBean {

    private String uuid;
    private String nickname;
    private String content;
    private Date createdAt;

    public MessageBean(String nickname, String content) {
        this.uuid = UUID.randomUUID().toString().replace("-", "");
        this.nickname = nickname;
        this.content = content;
        this.createdAt = new Date();
    }
}
