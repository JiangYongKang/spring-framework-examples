# 一、这个示例做什么

这个目录是打成 war 的 Spring MVC 示例。Servlet 容器启动时用 Java 配置注册 `DispatcherServlet`，页面使用 JSP。

依赖是 spring-webmvc 4.3.18.RELEASE、servlet-api 3.1.0，以及 JSTL 1.2。

# 二、请求怎么进来

1. `WebApplicationConfig` 实现 `WebApplicationInitializer`。容器启动时它创建注解上下文，注册 `WebAutoConfiguration`，再把名为 dispatcher 的 `DispatcherServlet` 映射到 `/`。
2. `WebAutoConfiguration` 打开 `@EnableWebMvc`，并扫描 `com.vincent.spring.framework.example`。
3. 视图解析器是 `InternalResourceViewResolver`，视图类是 `JstlView`，前缀是 `/WEB-INF/views`，后缀是 `.jsp`。
4. `MessageController` 处理 `GET /message`。它生成一个去掉横线的 UUID，放进模型，视图名是 `/message/index`。
5. 拼出来的页面是 `/WEB-INF/views/message/index.jsp`，页面上显示 `random uuid`。
6. `webapp/index.jsp` 是静态页，正文是 `Hello Servlet 3.0`。
