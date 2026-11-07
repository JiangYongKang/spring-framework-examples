# 一、这个示例做什么

这个目录用 Thymeleaf 渲染一个 HTML 页面。打包方式是 war。依赖是 spring-webmvc 4.3.18.RELEASE 和 thymeleaf-spring4 3.0.9.RELEASE。

# 二、请求怎么进来

1. `web.xml` 把欢迎页写成 `index.jsp`。模块里没有这个文件。
2. `DispatcherServlet` 读取 `classpath:spring-mvc-config.xml`。它和字符编码过滤器都映射到 `/`，过滤器把编码设为 utf-8。
3. XML 扫描 `com.vincent.spring.framework.example`。模板解析器的前缀是 `/WEB-INF/templates/`，后缀是 `.html`，模板模式是 HTML5。
4. `MessageController` 处理 `GET /messages`。模型里放入 `message=Hello Thymeleaf`，视图名是 `messages/index`。
5. 页面对应 `WEB-INF/templates/messages/index.html`，用 `th:text` 输出模型里的 `message`。
