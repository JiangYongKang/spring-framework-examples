package com.vincent.spring.framework.example;

import java.util.List;

/**
 * Author: MessageDao
 * DateTime: 2018/10/16 23:55
 * Comment:
 */

public interface MessageDao {

    void createTable();

    boolean insert(Message message);

    List<Message> findAll();

}
