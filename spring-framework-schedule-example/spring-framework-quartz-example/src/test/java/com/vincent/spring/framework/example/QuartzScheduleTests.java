package com.vincent.spring.framework.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Author: vincent
 * DateTime: 2018/11/6 23:10
 * Comment:
 */

@RunWith(SpringRunner.class)
@Sql("classpath:schema/tables_h2.sql")
@ContextConfiguration("classpath:spring-content.xml")
public class QuartzScheduleTests {

    @Test
    public void test() throws SchedulerException, InterruptedException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();
        Thread.sleep(1000 * 10);
        scheduler.shutdown();
    }

}
