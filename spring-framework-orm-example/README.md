# 一、这个目录做什么

这是聚合模块，packaging 为 pom。下面三个子模块各自演示一种数据访问写法，彼此没有代码调用。

# 二、子模块

1. [spring-framework-datasource-example](spring-framework-datasource-example/README.md) 用 `DriverManagerDataSource` 连接本机 MySQL。
2. [spring-framework-druid-example](spring-framework-druid-example/README.md) 用 Druid 连接池连接同一台 MySQL，并挂上 Druid 监控页。
3. [spring-framework-h2-example](spring-framework-h2-example/README.md) 用 `JdbcTemplate` 读写内存 H2 里的 `message` 表。
