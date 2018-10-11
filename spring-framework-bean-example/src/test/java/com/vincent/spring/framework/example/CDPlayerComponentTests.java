package com.vincent.spring.framework.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @ClassName: CDPlayerComponentTests
 * @Description:
 * @Author: vincent
 * @Date: 2018/10/11 21:22
 * @Version: V1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContextConfig.class)
public class CDPlayerComponentTests {

    @Resource
    private CDPlayerComponent component;

    @Test
    public void playTest() {
        Assert.assertNotNull(component);
        Assert.assertEquals(component.play(), "Hello Spring Beans");
    }

}
