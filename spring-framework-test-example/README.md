# 一、这个示例做什么

这个目录用内存 H2 支撑一套留言接口，再用 MockMvc 发请求。打包方式是 war。

依赖是 spring-webmvc、spring-orm 4.3.18.RELEASE、servlet-api 3.1.0、H2 1.4.197、json-path 2.4.0、json-path-assert 0.8.1，以及 jackson-databind 2.9.7。

# 二、接口和数据

`web.xml` 让 `DispatcherServlet` 读取 `classpath:spring-mvc-config.xml`。Servlet 和字符编码过滤器都映射到 `/`。MVC 配置扫描 `com.vincent.spring.framework`，并导入 `datasource.xml`。

数据源是 `jdbc:h2:mem:test`，模式 MySQL，用户 `sa`，密码为空。同一份配置创建 `JdbcTemplate` 和 `DataSourceTransactionManager`。

`MessageController` 映射在 `/messages`。

1. `GET /messages` 执行 `select * from message`，返回列表。
2. `POST /messages` 读取请求体里的 `Message`，插入 `id`、`nickname`、`content`、`created_time`、`updated_time`，再把这个对象返回。
3. `PUT /messages/{uuid}` 把路径里的 uuid 写回对象，再按主键更新。更新语句的占位符顺序是昵称、内容、更新时间、主键，传入的实参依次是昵称、创建时间、更新时间、uuid。
4. `DELETE /messages/{uuid}` 执行 `delete from message where id = ?`，响应体是这个 uuid。
5. 四个方法都返回 HTTP 200。`Message` 的构造方法会生成去掉横线的 uuid，并设置创建时间，更新时间留空。

建表脚本 `db-schema-test.sql` 创建 `message` 表，主键是 varchar。种子脚本 `db-seed-test.sql` 插入两条记录，昵称都是 `vincent`。

# 三、测试分别覆盖什么

1. `DataSourceTests` 加载 MVC 配置，只断言 `DataSource` 不为空。
2. `SQLScriptTests` 用 `@Sql` 连续执行建表脚本和种子脚本，再查询 `message`，断言有 2 条记录。
3. `MessageControllerTests` 标了 `@WebAppConfiguration`。它先执行建表脚本，每个用例前再插入昵称为 `vincent` 和 `alice` 的两条留言。MockMvc 固定期望状态码 200 和 JSON 响应。列表用例用 JsonPath 检查条数、昵称和内容，创建、更新、删除各发一次请求。
4. `TransactionTests` 在类上标了 `@Transactional`。事务开始前和结束后各有一个方法打印文字。一个用例标了 `@Commit`，另一个标了 `@Rollback`，方法体没有修改数据。
