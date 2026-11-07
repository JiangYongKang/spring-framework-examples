# 一、这个示例做什么

这个目录用 XML 给 `MessageService.call()` 挂通知。依赖有 spring-context、spring-context-support 4.3.18.RELEASE，以及 aspectjweaver 1.9.1。

# 二、调用时会发生什么

1. `MessageService.call()` 打一行 `Hello World!`。
2. `MessageAspect` 提供 `beforeAction()` 和 `afterAction()`，各自打一行日志。
3. `spring-config.xml` 打开 `aspectj-autoproxy`，注册目标 Bean 和切面 Bean。切点是 `execution(* com.vincent.spring.framework.example.MessageService.call(..))`。
4. 两个通知方法都写在 `aop:before` 上。调用 `call()` 之前，容器先执行 `beforeAction()`，再执行 `afterAction()`。

# 三、测试

`MessageAspectTests` 用 `SpringJUnit4ClassRunner` 加载 `classpath:spring-config.xml`，注入 `MessageService` 并调用 `call()`。测试方法里没有断言。
