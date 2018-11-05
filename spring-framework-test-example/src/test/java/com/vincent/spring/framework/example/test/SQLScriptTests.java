package com.vincent.spring.framework.example.test;

import com.vincent.spring.framework.model.Message;
import com.vincent.spring.framework.service.MessageService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

import static com.vincent.spring.framework.service.MessageService.buildMessage;

/**
 * Author: vincent
 * Date: 2018-11-03 15:08:00
 * Comment:
 * @Sql 用于注释测试类或测试方法，配置在集成测试期间针对给定数据库运行的 SQL 脚本
 * <p>
 * @SqlConfig 定义元数据，用于确定如何解析和运行使用 @Sql 批注配置的 SQL 脚本。
 * <p>
 * @SqlGroup 是一个容器注释，它聚合了几个 @Sql 注释。可以原生使用 @SqlGroup 来声明几个嵌套的@Sql注释，
 * 或者可以将它与 Java8 对可重复注释的支持结合使用，其中 @Sql 可以在同一个类或方法上多次声明，隐式生成此容器注释。
 */

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring-mvc-config.xml")
@Sql(value = { "classpath:db-schema-test.sql", "classpath:db-seed-test.sql" })
public class SQLScriptTests {

    @Resource
    private JdbcTemplate template;

    @Test
    public void seedTest() {
        List<Message> messages = template.query("select * from message", (resultSet, i) -> buildMessage(resultSet));
        Assert.assertNotNull(messages);
        Assert.assertEquals(messages.size(), 2);
    }

}
