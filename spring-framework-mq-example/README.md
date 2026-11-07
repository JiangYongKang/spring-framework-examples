# 一、这个示例做什么

这个目录用 Spring JMS 连接本机 ActiveMQ，向一个队列发送文本，并用监听器接收。

依赖是 spring-jms 4.3.18.RELEASE 和 activemq-core 5.7.0。

# 二、消息怎么走

1. `ActiveMQConnectionFactory` 的地址是 `tcp://localhost:61616`，外面再包一层 `CachingConnectionFactory`。
2. 队列名是 `TEST_QUEUE`。`JmsTemplate` 把这个队列设为默认目的地。
3. `MessageSender` 在构造时接收 `JmsTemplate`，`send()` 调用 `convertAndSend` 发送文本。
4. `MessageReceiver` 实现 `MessageListener`。`onMessage()` 把收到的 JMS `Message` 对象写进日志，没有再取出文本。
5. `SimpleMessageListenerContainer` 使用同一个连接工厂、队列和监听器。

# 三、测试

`MessageSenderTest` 加载 `classpath:spring-context-config.xml`，调用 `messageSender.send("Hello World")`。用例结束后再等待 3 秒。
