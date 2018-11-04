package com.vincent.spring.framework.example.test;

import com.vincent.spring.framework.model.Message;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author: vincent
 * Date: 2018-11-03 15:08:00
 * Comment:
 */

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring-mvc-config.xml")
@Sql(value = { "classpath:db-schema-test.sql", "classpath:db-seed-test.sql" })
public class SQLScriptTests {

    @Resource
    private JdbcTemplate template;

    @Test
    public void seedTest() {
        List<Message> messages = template.query("select * from message", (resultSet, i) -> {
            Message message = new Message();
            message.setUuid(resultSet.getString("id"));
            message.setNickname(resultSet.getString("nickname"));
            message.setContent(resultSet.getString("content"));
            message.setCreatedTime(resultSet.getDate("created_time"));
            message.setUpdatedTime(resultSet.getDate("updated_time"));
            return message;
        });
        Assert.assertNotNull(messages);
        Assert.assertEquals(messages.size(), 2);
    }

}
