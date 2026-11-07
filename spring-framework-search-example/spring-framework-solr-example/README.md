# 一、这个示例做什么

这个目录按配置创建一个 Solr 的 HTTP 客户端。依赖是 spring-context 4.3.18.RELEASE 和 spring-data-solr 4.0.0.RELEASE。

# 二、客户端怎么创建

`spring-solr-config.xml` 读取 `solr.properties`，把 `solr.url` 传给 `HttpSolrClient` 里名为 `builder` 的构造参数。

属性值是 `http://127.0.0.1:8983/slor/namespace`。

# 三、测试

`HttpSolrClientTests` 加载 `classpath:spring-solr-config.xml`，注入 `HttpSolrClient`，只断言它不为空。测试里没有执行查询。
