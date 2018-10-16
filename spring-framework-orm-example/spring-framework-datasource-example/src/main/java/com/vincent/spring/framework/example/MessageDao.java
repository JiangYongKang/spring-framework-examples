package com.vincent.spring.framework.example;

import java.util.List;

/**
 * Author: MessageDao
 * DateTime: 2018/10/14 21:07
 * Comment:
 */

public interface MessageDao {

    List<Message> findAll();

}
