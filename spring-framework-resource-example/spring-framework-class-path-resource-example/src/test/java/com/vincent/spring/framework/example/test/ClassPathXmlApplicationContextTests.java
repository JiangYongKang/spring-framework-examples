package com.vincent.spring.framework.example.test;

import com.vincent.spring.framework.example.MessageBean;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: vincent
 * Date: 2018-10-15 17:42:00
 * Comment: 从 classpath 加载配置文件
 */

public class ClassPathXmlApplicationContextTests {

    private ApplicationContext applicationContext;

    @Before
    public void beforeAction() {
        applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
    }

    @Test
    public void createBeanTest() {
        MessageBean messageBean = applicationContext.getBean(MessageBean.class);
        Assert.assertNotNull(messageBean);
        Assert.assertEquals(messageBean.getNickname(), "vincent");
        Assert.assertEquals(messageBean.getContent(), "this is a test message.");
    }

}
