# 一、这个目录做什么

这是聚合模块，packaging 为 pom。定时任务的代码都在下面的 Quartz 子模块里。

# 二、子模块

[spring-framework-quartz-example](spring-framework-quartz-example/README.md) 用 Quartz 每 5 秒执行一次打印任务。调度数据放在内存 H2 里，启动时执行 Quartz 的 H2 建表脚本。
