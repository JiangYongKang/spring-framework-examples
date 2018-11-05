package com.vincent.spring.framework.service;

import com.vincent.spring.framework.model.Message;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Author: vincent
 * Date: 2018-11-05 09:41:00
 * Comment:
 */

@Service
public class MessageService {

    @Resource
    private JdbcTemplate template;

    public List<Message> index() {
        return template.query("select * from message", (resultSet, i) -> buildMessage(resultSet));
    }

    public int create(Message message) {
        return template.update(
                "insert into message (id, nickname, content, created_time, updated_time) values (?, ?, ?, ?, ?)",
                message.getUuid(), message.getNickname(), message.getContent(), message.getCreatedTime(), message.getUpdatedTime()
        );
    }

    public int update(Message message) {
        return template.update(
                "update message set nickname = ?, content = ?, updated_time = ? where id = ?",
                message.getNickname(), message.getCreatedTime(), message.getUpdatedTime(), message.getUuid()
        );
    }

    public int destroy(String uuid) {
        return template.update("delete from message where id = ?", uuid);
    }

    public static Message buildMessage(ResultSet resultSet) throws SQLException {
        Message message = new Message();
        message.setUuid(resultSet.getString("id"));
        message.setNickname(resultSet.getString("nickname"));
        message.setContent(resultSet.getString("content"));
        message.setCreatedTime(resultSet.getDate("created_time"));
        message.setUpdatedTime(resultSet.getDate("updated_time"));
        return message;
    }

}
