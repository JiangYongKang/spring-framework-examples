# 一、仓库说明

这是一套按主题拆开的 Spring Framework 示例。根目录是 Maven 聚合工程，每个子目录演示一块用法，模块之间没有业务上的互相调用。

代码停留在 2018 年到 2019 年的写法。容器多用 XML 或 Java 配置启动，测试使用 JUnit 4 和 Spring Test。每个模块的逻辑写在该目录自己的 README.md 里。

# 二、公共构建约定

根 pom 的 packaging 是 pom，下面挂了 11 个模块。它统一声明 Java 8、UTF-8、Spring 4.3.18.RELEASE，以及 spring-data-redis 1.8.13.RELEASE。

所有模块共用这些依赖：spring-test 4.3.18.RELEASE、JUnit 4.12、Lombok 1.18.2、slf4j-simple 1.7.26。编译插件把 source 和 target 都写成 1.8，另外还配置了 maven-war-plugin 3.2.2。

`.travis.yml` 里只写了 `language: java`，没有指定 JDK 发行版，也没有写构建命令。

# 三、模块一览

| 目录 | 代码在做什么 |
| --- | --- |
| [spring-framework-web-example](spring-framework-web-example/README.md) | 用 Java 配置和 XML 各搭一个返回 JSP 的 Spring MVC |
| [spring-framework-bean-example](spring-framework-bean-example/README.md) | 用 Java 配置注册 Bean，并扫描带注解的组件 |
| [spring-framework-aop-example](spring-framework-aop-example/README.md) | 用 XML 给一个方法挂前置通知 |
| [spring-framework-thymeleaf-example](spring-framework-thymeleaf-example/README.md) | 用 Thymeleaf 渲染一个带模型数据的页面 |
| [spring-framework-resource-example](spring-framework-resource-example/README.md) | 分别从 classpath 和文件系统加载 XML |
| [spring-framework-orm-example](spring-framework-orm-example/README.md) | 配置 MySQL 数据源、Druid 连接池，并用 JdbcTemplate 访问内存 H2 |
| [spring-framework-search-example](spring-framework-search-example/README.md) | 按配置创建一个 Solr 的 HTTP 客户端 |
| [spring-framework-test-example](spring-framework-test-example/README.md) | 用 MockMvc、SQL 脚本和事务注解测试一套留言接口 |
| [spring-framework-schedule-example](spring-framework-schedule-example/README.md) | 用 Quartz 周期执行任务，调度数据放在内存 H2 |
| [spring-framework-cache-example](spring-framework-cache-example/README.md) | 用 Redis 做 Spring Cache，文章数据放在内存列表里 |
| [spring-framework-mq-example](spring-framework-mq-example/README.md) | 用 Spring JMS 向 ActiveMQ 队列收发文本 |

# 四、许可

本仓库以 GNU General Public License v3.0 发布。分发或修改时，需要保留 LICENSE 里的许可文本。
