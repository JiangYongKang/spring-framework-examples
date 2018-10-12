package com.vincent.spring.framework.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Author: vincent
 * Date: 2018-10-11 18:55:00
 * Comment:
 */

@Configuration
@ComponentScan(basePackages = "com.vincent.spring.framework.example", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
})
public class RootConfig {

}
