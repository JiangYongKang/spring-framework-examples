package com.vincent.spring.framework.example.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Author: vincent
 * Date: 2018-10-25 11:23:00
 * Comment:
 */

@WebAppConfiguration
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring-mvc-config.xml")
public class MessageControllerTests {

    @Resource
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext)
                .alwaysExpect(status().isOk())
                .alwaysExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .build();
    }

    @Test
    public void indexTest() throws Exception {
        this.mockMvc.perform(get("/messages").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }
}
