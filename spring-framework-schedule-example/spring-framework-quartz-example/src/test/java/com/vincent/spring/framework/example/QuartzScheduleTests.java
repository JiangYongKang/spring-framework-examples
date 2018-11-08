package com.vincent.spring.framework.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Author: vincent
 * DateTime: 2018/11/6 23:10
 * Comment:
 */

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring-content.xml")
public class QuartzScheduleTests {

    @Test
    public void test() throws InterruptedException {
        Thread.sleep(1000 * 60);
    }

}
