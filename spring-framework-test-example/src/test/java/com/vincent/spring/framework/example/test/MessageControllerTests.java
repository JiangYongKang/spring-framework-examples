package com.vincent.spring.framework.example.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vincent.spring.framework.model.Message;
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
import java.util.UUID;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
        this.mockMvc.perform(get("/messages").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].nickname", is("vincent")))
                .andExpect(jsonPath("$[1].nickname", is("nick")))
                .andExpect(jsonPath("$[0].content", is("this is test message")))
                .andExpect(jsonPath("$[1].content", is("this is test message")));
    }

    @Test
    public void createTest() throws Exception {
        Message message = new Message("stefan", "test");
        String requestBody = new ObjectMapper().writeValueAsString(message);
        this.mockMvc.perform(post("/messages").contentType(MediaType.APPLICATION_JSON_UTF8).content(requestBody))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.nickname", is("stefan")))
                .andExpect(jsonPath("$.content", is("test")));
    }

    @Test
    public void updateTest() throws Exception {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        Message message = new Message("stefan", "test");
        String requestBody = new ObjectMapper().writeValueAsString(message);
        this.mockMvc.perform(put("/messages/" + uuid).contentType(MediaType.APPLICATION_JSON_UTF8).content(requestBody))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.nickname", is("stefan")))
                .andExpect(jsonPath("$.content", is("test")));
    }

    @Test
    public void deleteTest() throws Exception {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        this.mockMvc.perform(delete("/messages/" + uuid).accept(MediaType.APPLICATION_JSON_UTF8).contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.uuid", is(uuid)));
    }
}
