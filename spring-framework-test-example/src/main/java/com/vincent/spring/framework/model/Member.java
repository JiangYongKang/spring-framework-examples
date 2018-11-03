package com.vincent.spring.framework.model;

import lombok.Data;

import java.util.Date;

/**
 * Author: vincent
 * Date: 2018-11-03 15:38:00
 * Comment:
 */

@Data
public class Member {

    private Integer id;
    private String email;
    private String pwd;
    private Date createdTime;
    private Date updatedTime;

}
