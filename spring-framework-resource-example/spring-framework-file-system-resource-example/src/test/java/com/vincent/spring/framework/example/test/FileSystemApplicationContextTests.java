package com.vincent.spring.framework.example.test;

import com.vincent.spring.framework.example.MessageBean;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Author: vincent
 * Date: 2018-10-15 18:29:00
 * Comment: 加载指定路径的配置文件，这里要注意相对路径和绝对路径。
 */

public class FileSystemApplicationContextTests {

    private ApplicationContext applicationContext;

    @Before
    public void beforeAction() {
        this.applicationContext = new FileSystemXmlApplicationContext("config/spring-config.xml");
    }

    @Test
    public void createBeanTest() {
        MessageBean messageBean = applicationContext.getBean(MessageBean.class);
        Assert.assertNotNull(messageBean);
        Assert.assertEquals(messageBean.getNickname(), "vincent");
        Assert.assertEquals(messageBean.getContent(), "this is a test message.");
    }

}
