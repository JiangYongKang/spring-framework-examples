# 一、这个示例做什么

这个目录把 Druid 连接池放进一个 war。依赖是 spring-webmvc、spring-orm 4.3.18.RELEASE、mysql-connector-java 8.0.12、Druid 1.1.10，以及 servlet-api 3.1.0。

# 二、连接池怎么配

`spring-druid-config.xml` 读取 `druid.properties`，创建 `DruidDataSource`。初始化方法是 `init`，销毁方法是 `close`。

1. 地址同样指向 `127.0.0.1:3306` 上的库 `spring-framework-example`，用户名和密码都是 `root`。驱动类名是 `com.mysql.cj.jdbc.Driver`。
2. 初始连接数是 5，最小空闲是 10，最大连接数是 20，获取连接最多等待 60000 毫秒。
3. 空闲连接检测间隔是 2000 毫秒。连接最少闲置 600000 毫秒、最多闲置 900000 毫秒后可被回收。
4. 校验语句是 `select 1`。空闲时检测连接，借出和归还时不检测。
5. `filters` 是 `stat`。预处理语句池关闭，单连接预处理语句上限写成 20。

# 三、Web 上暴露了什么

1. `DispatcherServlet` 映射到 `/*`，上下文文件是 `classpath:spring-druid-config.xml`。这份文件里只有数据源。
2. `StatViewServlet` 挂在 `/druid/*`，用来看 Druid 监控页。
3. 字符编码过滤器把编码设为 utf-8，映射到 `/*`。
4. `WebStatFilter` 也映射到 `/*`。它排除 `/public/*`、静态资源、`/druid*` 和 jsp，并打开 profile。
