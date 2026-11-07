# 一、这个目录做什么

这是聚合模块，packaging 为 pom。下面两个子模块各自是一个返回 JSP 的 Spring MVC 工程，一个用 Java 配置启动，一个用 XML 启动。

# 二、子模块

1. [spring-framework-annotation-web-example](spring-framework-annotation-web-example/README.md) 在 Servlet 容器启动时注册 `DispatcherServlet`。访问 `/message` 时，JSP 显示一个 UUID。
2. [spring-framework-xml-web-example](spring-framework-xml-web-example/README.md) 用 `web.xml` 加载 MVC 配置。访问 `/welcome` 时，JSP 显示运行环境信息。
