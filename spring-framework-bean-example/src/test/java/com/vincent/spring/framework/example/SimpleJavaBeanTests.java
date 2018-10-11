package com.vincent.spring.framework.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Author: SimpleJavaBeanTests
 * DateTime: 2018/10/11 22:14
 * Comment:
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContextConfig.class)
public class SimpleJavaBeanTests {

    @Resource
    private SimpleJavaBean simpleJavaBean;

    @Test
    public void componentTest() {
        Assert.assertNotNull(simpleJavaBean);
    }

}
