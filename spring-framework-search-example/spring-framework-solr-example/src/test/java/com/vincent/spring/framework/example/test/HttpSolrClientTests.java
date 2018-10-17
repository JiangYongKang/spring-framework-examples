package com.vincent.spring.framework.example.test;

import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Author: vincent
 * Date: 2018-10-17 14:13:00
 * Comment:
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-solr-config.xml")
public class HttpSolrClientTests {

    @Resource
    private HttpSolrClient solrClient;

    @Test
    public void solrClientTest() {
        Assert.assertNotNull(solrClient);
    }

}
