package com.vincent.spring.framework.example.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Author: vincent
 * Date: 2018-10-17 09:17:00
 * Comment:
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-datasource-config.xml")
public class DataSourceTests {

    @Resource
    private DataSource dataSource;

    @Test
    public void dataSourceTest() {
        Assert.assertNotNull(dataSource);
    }

}
