# 一、这个示例做什么

这个目录用 `JdbcTemplate` 读写内存 H2。pom 的 packaging 是 war，目录里没有 `web.xml` 和页面，实际内容是数据访问代码和测试。

依赖是 spring-webmvc、spring-orm 4.3.18.RELEASE、servlet-api 3.1.0，以及 H2 1.4.197。

# 二、数据库和表

`datasource.properties` 指向 `jdbc:h2:mem:spring-framework-h2-example`，模式是 MySQL，用户 `sa`，密码为空。`spring-content-config.xml` 用这个数据源创建 `JdbcTemplate`，并扫描 `com.vincent.spring.framework.example`。

`Message` 有 `id`、`context`、`status`、`createdAt`、`updatedAt`。只传入内容的构造方法会把 `context` 设成参数，并把两个时间设成当前时间。

`MessageDaoImpl` 做三件事。

1. `createTable()` 执行建表 SQL，创建 `message` 表。主键自增，内容列叫 `content`。
2. `insert()` 把 `context`、`status` 和两个时间写入 `content`、`status`、`created_at`、`updated_at`。影响行数等于 1 时返回 true。
3. `findAll()` 执行 `select * from message`，把 `content` 读回 `Message.context`。

# 三、测试

`MessageDaoTests` 加载 `classpath:spring-content-config.xml`。每个用例开始前先建表，再插入两条内容为 `vincent` 的记录。`findAllTest` 断言结果有 2 条，且第一条内容是 `vincent`。
