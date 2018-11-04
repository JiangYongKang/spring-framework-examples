package com.vincent.spring.framework.example.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vincent.spring.framework.controller.MessageController;
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
 * @WebAppConfiguration spring mvc test 构建在 servlet api 模拟对象之上，因此不使用正在运行的 servlet 容器。允许执行请求并生成响应，而无需在 servlet 容器中运行。
 * 测试依赖于 TestContext 框架的 WebApplicationContext 支持。
 * <p>
 * @ContextConfiguration 加载 spring mvc 的配置
 * <p>
 * MockMvc 实例用于对 API 接口执行请求，并验证生成的响应的状态、内容类型、响应正文。这里使用了 com.jayway.jsonpath 项目对返回的 JSON 内容做验证
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

//        this.mockMvc = MockMvcBuilders.standaloneSetup(new MessageController())
//                .alwaysExpect(status().isOk())
//                .alwaysExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
//                .build();
    }

    @Test
    public void indexTest() throws Exception {
        this.mockMvc.perform(get("/messages").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
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
                .andExpect(jsonPath("$.nickname", is("stefan")))
                .andExpect(jsonPath("$.content", is("test")));
    }

    @Test
    public void deleteTest() throws Exception {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        this.mockMvc.perform(delete("/messages/" + uuid).accept(MediaType.APPLICATION_JSON_UTF8).contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(jsonPath("$.uuid", is(uuid)));
    }
}
