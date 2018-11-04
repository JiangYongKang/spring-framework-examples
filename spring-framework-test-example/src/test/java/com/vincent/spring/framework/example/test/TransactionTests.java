package com.vincent.spring.framework.example.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Author: vincent
 * Date: 2018-11-04 09:50:00
 * Comment:
 * @BeforeTransaction 表示在启动事务之前应该执行的方法，必须与 @Transactional 注解结合使用，
 * 从 Spring Framework 4.3 开始，@BeforeTransaction 方法不需要是公共的，可以在基于 Java8 的接口默认方法中声明。
 * <p>
 * @AfterTransaction 表示在启动事务之后应该执行的方法
 * <p>
 * @Commit 表示应在测试方法完成后提交事务测试方法的事务。它与 @Rollback(false) 是一样的
 * <p>
 * @Rollback 表示在测试方法完成后是否应回滚事务测试方法的事务。如果为 true，则回滚事务。否则，提交事务 (与 @Commit 的行为一致)
 * 即使没有显式声明 @Rollback，Spring TestContext Framework 中的集成测试的回滚也默认为 true
 * 声明为类级别注释时，@Rollback 定义测试类层次结构中所有测试方法都会默认回滚
 * 当声明为方法级注释时，@Rollback 定义特定测试方法的回滚，可能会覆盖类级别的 @Rollback 或 @Commit
 */

@Transactional
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring-mvc-config.xml")
public class TransactionTests {

    @Resource
    private JdbcTemplate template;

    @BeforeTransaction
    public void beforeTransaction() {
        System.out.println("在开启事务之前执行");
    }

    @AfterTransaction
    public void afterTransaction() {
        System.out.println("在结束事务之后执行");
    }

    @Test
    @Commit
    public void commitTest() {
        System.out.println("执行完毕后提交事务");
    }

    @Test
    @Rollback
    public void rollbackTest() {
        System.out.println("执行完毕之后回滚事务");
    }

}
