# 一、这个目录做什么

这是聚合模块，packaging 为 pom。下面两个子模块定义了同一份 `MessageBean`，差别在于 XML 从哪里读入。

# 二、子模块

1. [spring-framework-class-path-resource-example](spring-framework-class-path-resource-example/README.md) 用 `ClassPathXmlApplicationContext` 读取 classpath 上的 `spring-config.xml`。
2. [spring-framework-file-system-resource-example](spring-framework-file-system-resource-example/README.md) 用 `FileSystemXmlApplicationContext` 读取模块 `config` 目录里的 `spring-config.xml`。
