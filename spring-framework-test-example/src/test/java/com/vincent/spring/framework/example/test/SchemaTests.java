package com.vincent.spring.framework.example.test;

import com.vincent.spring.framework.model.Member;
import org.junit.Assert;
import org.junit.Before;
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
@Sql("classpath:db-schema-test.sql")
public class SchemaTests {

    @Resource
    private JdbcTemplate template;

    @Test
    public void schemaTest() {
//        List<Member> members = template.query("select * from member", (resultSet, i) -> {
//            Member member = new Member();
//            member.setId(resultSet.getInt("id"));
//            member.setEmail(resultSet.getString("email"));
//            member.setPwd(resultSet.getString("pwd"));
//            member.setCreatedTime(resultSet.getDate("created_time"));
//            member.setUpdatedTime(resultSet.getDate("updated_time"));
//            return member;
//        });
//        Assert.assertNotNull(members);
    }

}
