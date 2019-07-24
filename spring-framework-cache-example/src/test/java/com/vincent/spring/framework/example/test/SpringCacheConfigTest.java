package com.vincent.spring.framework.example.test;

import com.vincent.spring.framework.example.Article;
import com.vincent.spring.framework.example.ArticleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * author: vincent
 * date: 2019-05-21 00:19
 * comment:
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context-config.xml")
public class SpringCacheConfigTest {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Resource
    private ArticleService articleService;

    @Test
    public void redisTemplateTest() {
        Assert.assertNotNull(redisTemplate);
        redisTemplate.opsForValue().set("HELLO", "WORLD");
        Assert.assertEquals(redisTemplate.opsForValue().get("HELLO"), "WORLD");
        redisTemplate.delete("HELLO");
        Assert.assertNull(redisTemplate.opsForValue().get("HELLO"));
    }

    @Test
    public void articleServiceTest() {
        Assert.assertNotNull(articleService);
        articleService.save(new Article(1, "HELLO", "WORLD", new Date()));
    }

}
