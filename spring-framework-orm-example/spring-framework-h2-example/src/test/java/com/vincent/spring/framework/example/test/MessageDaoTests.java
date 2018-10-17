package com.vincent.spring.framework.example.test;

import com.vincent.spring.framework.example.MessageDao;
import com.vincent.spring.framework.example.Message;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Author: MessageDaoTests
 * DateTime: 2018/10/17 21:29
 * Comment:
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-content-config.xml")
public class MessageDaoTests {

    @Resource
    private MessageDao messageDao;

    @Before
    public void beforeAction() {
        messageDao.createTable();
        messageDao.insert(new Message("vincent"));
        messageDao.insert(new Message("vincent"));
    }

    @Test
    public void findAllTest() {
        List<Message> messages = messageDao.findAll();
        Assert.assertNotNull(messages);
        Assert.assertFalse(messages.isEmpty());
        Assert.assertEquals(messages.size(), 2);
        Assert.assertEquals(messages.get(0).getContext(), "vincent");
    }

}
