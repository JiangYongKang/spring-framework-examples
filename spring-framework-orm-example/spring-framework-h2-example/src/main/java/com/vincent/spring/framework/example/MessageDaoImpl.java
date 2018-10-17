package com.vincent.spring.framework.example;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author: MessageDaoImpl
 * DateTime: 2018/10/16 23:56
 * Comment:
 */

@Repository
public class MessageDaoImpl implements MessageDao {

    @Resource
    private JdbcTemplate template;

    @Override
    public void createTable() {
        String sql = "create table message (" +
                "  id         int auto_increment primary key," +
                "  content    varchar(255)            null," +
                "  status     tinyint(1) default '1' null," +
                "  created_at timestamp default '0000-00-00 00:00:00' not null," +
                "  updated_at timestamp default '0000-00-00 00:00:00' not null" +
                ")";
        template.execute(sql);
    }

    @Override
    public boolean insert(Message message) {
        String sql = "insert into message(content, status, created_at, updated_at) values (?, ?, ?, ?)";
        return template.update(sql, message.getContext(), message.getStatus(), message.getCreatedAt(), message.getUpdatedAt()) == 1;
    }

    @Override
    public List<Message> findAll() {
        String sql = "select * from message";
        return template.query(sql, (resultSet, i) -> {
            Message message = new Message();
            message.setId(resultSet.getInt("id"));
            message.setContext(resultSet.getString("content"));
            message.setCreatedAt(resultSet.getDate("created_at"));
            message.setUpdatedAt(resultSet.getDate("updated_at"));
            return message;
        });
    }
}
