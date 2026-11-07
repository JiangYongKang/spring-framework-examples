# 一、这个示例做什么

这个目录演示从 classpath 加载 Spring XML，再按类型取出 Bean。依赖是 spring-context 4.3.18.RELEASE。

# 二、配置里声明了什么

`src/main/resources/spring-config.xml` 扫描 `com.vincent.spring.framework.example`，并用构造参数创建 `MessageBean`。`nickname` 是 `vincent`，`content` 是 `this is a test message.`。

构造方法还会生成去掉横线的 UUID，并把 `createdAt` 设成当前时间。

# 三、测试

`ClassPathXmlApplicationContextTests` 执行 `new ClassPathXmlApplicationContext("spring-config.xml")`，按类型取出 `MessageBean`，再核对昵称和内容。
