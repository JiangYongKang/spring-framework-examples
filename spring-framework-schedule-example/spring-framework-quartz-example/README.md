# 一、这个示例做什么

这个目录用 Quartz 周期执行一个打印任务，并把调度数据放在内存 H2 里。

依赖是 quartz、quartz-jobs 2.2.1，spring-orm、spring-context-support 4.3.18.RELEASE，以及 H2 1.4.197。

# 二、调度怎么配

数据源是 `jdbc:h2:mem:example`，模式 MySQL，用户 `sa`，密码为空。`spring-content.xml` 在容器启动时执行 `schema/tables_h2.sql`。`schema` 目录里还有其他数据库的 Quartz 建表脚本，当前配置没有引用它们。

`quartz-scheduler.properties` 把实例名设为 `SchedulerExample`，线程数设为 3。JobStore 使用 `JobStoreTX`，并打开集群开关。

1. `TestQuartzJob` 继承 `QuartzJobBean`。执行时打印 `Hello Quartz` 和当前时间。
2. `JobDetailFactoryBean` 把这个类注册成任务。
3. `CronTriggerFactoryBean` 的 cron 是 `0/5 * * * * ?`。
4. `SchedulerFactoryBean` 绑定数据源、属性文件和这个触发器。启动延迟是 1 秒，`overwriteExistingJobs` 为 false。

# 三、测试

`QuartzScheduleTests` 加载 `classpath:spring-content.xml`，然后睡眠 60 秒，让调度器在这段时间里触发任务。
