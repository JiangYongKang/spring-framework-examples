package com.vincent.spring.framework.example;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Author: MessageDaoImpl
 * DateTime: 2018/10/14 21:07
 * Comment:
 */

@Repository
public class MessageDaoImpl implements MessageDao {

    @Resource
    private JdbcTemplate template;

    @Override
    public List<Message> findAll() {
        String sql = "select * from message";
        return template.query(sql, new MessageRowMapper());
    }

    class MessageRowMapper implements RowMapper<Message> {
        @Override
        public Message mapRow(ResultSet resultSet, int i) throws SQLException {
            Message message = new Message();
            message.setId(resultSet.getInt("id"));
            message.setContent(resultSet.getString("content"));
            message.setStatus(resultSet.getBoolean("status"));
            message.setCreatedAt(resultSet.getDate("created_at"));
            message.setUpdatedAt(resultSet.getDate("updated_at"));
            return message;
        }
    }
}
