# 一、这个示例做什么

这个目录演示怎样用 Java 配置把对象放进 Spring 容器，再在测试里取出来。依赖是 spring-context 4.3.18.RELEASE。

# 二、容器里有哪些对象

1. `SpringContextConfig` 标了 `@Configuration` 和 `@ComponentScan`，扫描配置类自己所在的包。
2. `simpleJavaBean()` 标了 `@Bean`，返回一个没有字段的 `SimpleJavaBean`。
3. `CDPlayerComponent` 标了 `@Component`。`play()` 打一行日志，并返回 `Hello Spring Beans`。

# 三、测试在检查什么

1. `SimpleJavaBeanTests` 加载 `SpringContextConfig`，断言容器里能拿到 `SimpleJavaBean`。
2. `CDPlayerComponentTests` 调用 `play()`，断言返回值是 `Hello Spring Beans`。

# 四、构建文件

这个模块的 pom 把 packaging 写成 pom，又没有声明子模块。Maven 会把它当成聚合工程，默认构建停在聚合层，`src` 里的 Java 不进入编译。
