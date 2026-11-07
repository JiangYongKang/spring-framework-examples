# 一、这个示例做什么

这个目录用 `web.xml` 启动 Spring MVC，返回 JSP。打包方式是 war，依赖是 spring-webmvc 4.3.18.RELEASE。

# 二、请求怎么进来

1. `web.xml` 把欢迎页设为 `index.jsp`。这个页面写着 `Hello Spring`。
2. `DispatcherServlet` 读取 `classpath:spring-mvc-config.xml`。它和字符编码过滤器都映射到 `/`，过滤器把编码设为 utf-8。
3. XML 扫描 `com.vincent.spring.framework.example`，并打开注解驱动。视图前缀是 `/WEB-INF/views/`，后缀是 `.jsp`。
4. 同一份配置把 `/css/**` 指到 `/WEB-INF/css/`，把 `/js/**` 指到 `/WEB-INF/js/`。仓库里没有这两个目录。
5. `WelcomeController` 处理 `GET /welcome`。模型里放入操作系统名称、操作系统版本、`java.home`、`java.version` 和 `SpringVersion.getVersion()`。
6. 视图名是 `/welcome`，对应 `WEB-INF/views/welcome.jsp`。
