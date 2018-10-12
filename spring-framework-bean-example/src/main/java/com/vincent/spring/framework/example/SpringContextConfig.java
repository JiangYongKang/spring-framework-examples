package com.vincent.spring.framework.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * User: vincent
 * Date: 2017/7/19
 * Comment: 组件的扫描默认是不会启用的，需要手动的配置
 * 通过 @ComponentScan 能够在 Spring 中启用组件扫描。
 * 如果你更倾向于使用 XML 来启动的话，也可以通过 <context:component-scan/> 来启用组件扫描
 */

@Configuration
@ComponentScan
public class SpringContextConfig {

    /**
     * 这里的 @Bean 注解会告诉 Spring 这个方法将返回一个对象，该对象将要注册为 Spring 应用上下文中的 bean
     * @return 被 Spring 容器管理的 bean
     */
    @Bean
    public SimpleJavaBean simpleJavaBean() {
        return new SimpleJavaBean();
    }

}
