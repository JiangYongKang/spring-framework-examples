# 一、这个示例做什么

这个目录演示用 XML 声明一个 JDBC 数据源。依赖是 spring-context、spring-orm 4.3.18.RELEASE，以及 mysql-connector-java 8.0.12。

# 二、数据源怎么配

`spring-datasource-config.xml` 读取 `datasource.properties`，创建 `DriverManagerDataSource`。

1. 驱动类名是 `com.mysql.jdbc.Driver`。
2. 地址是 `jdbc:mysql://127.0.0.1:3306/spring-framework-example`。
3. 用户名和密码都是 `root`。

# 三、测试

`DataSourceTests` 加载这份 XML，注入 `DataSource`，只断言它不为空。测试里没有执行 SQL。
