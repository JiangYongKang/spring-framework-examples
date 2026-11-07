# 一、这个示例做什么

这个目录把 Spring Cache 指到 Redis。文章数据放在一个静态列表里，缓存配置写在 XML 中。

依赖是 spring-webmvc、spring-context-support 4.3.18.RELEASE、spring-data-redis 1.8.13.RELEASE、Jedis 2.9.0、jackson-databind 2.8.11.1，以及 aspectjweaver 1.9.4。

# 二、文章存在哪里

`Article` 有编号、标题、内容和创建时间，并实现了 `Serializable`。

`ArticleServiceImpl` 用静态 `ArrayList` 保存文章。

1. `list()` 返回这份列表。
2. `find()` 按编号查找，找不到时返回 null。
3. `save()` 把文章加入列表。
4. `update()` 先按编号删掉旧记录，删掉后再放入新记录，方法本身返回 true。
5. `delete()` 按编号删除，返回是否删掉了记录。

`spring-context-config.xml` 扫描 `com.vincent.spring.framework.example`，把 `ArticleServiceImpl` 注册成 `articleService`，再导入 Redis 配置和缓存配置。

# 三、缓存规则

Redis 连接 `localhost:6379`，使用 0 号库，密码为空。键用字符串序列化，值用 Jackson JSON 序列化。

缓存通知切到 `ArticleService` 的全部方法，缓存名是 `articles`，键生成器是 `SimpleKeyGenerator`。缓存管理器是 `RedisCacheManager`。

1. `list` 配置为可缓存。
2. `save` 配置为清除缓存。这一项没有写 `all-entries`，也没有指定和 `list` 相同的键，清除时使用 `save` 自己的参数生成键。
3. `find`、`update`、`delete` 没有单独的缓存规则。

# 四、测试

`SpringCacheConfigTest` 加载 `classpath:spring-context-config.xml`。

1. `redisTemplateTest` 写入键 `HELLO`，值为 `WORLD`，读回后删除，再断言这个键已经不存在。
2. `articleServiceTest` 保存一篇编号为 1、标题为 `HELLO`、内容为 `WORLD` 的文章。

这两步都要本机 Redis 能连上。
