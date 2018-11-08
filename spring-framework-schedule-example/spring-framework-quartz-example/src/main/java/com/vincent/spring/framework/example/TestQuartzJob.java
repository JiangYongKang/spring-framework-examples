package com.vincent.spring.framework.example;

import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * Author: vincent
 * DateTime: 2018/11/7 23:48
 * Comment:
 */

public class TestQuartzJob extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext context) {
        System.out.println("Hello Quartz " + new Date());
    }
}
