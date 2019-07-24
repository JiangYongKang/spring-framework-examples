package com.vincent.spring.framework.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * author: vincent
 * date: 2019-06-09 14:02
 * comment:
 */

@Data
@AllArgsConstructor
public class Article implements Serializable {

    /**
     * 文章编号
     */
    private Integer id;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 创建时间
     */
    private Date createTime;

}
