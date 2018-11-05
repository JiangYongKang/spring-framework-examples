# spring-framework-test-example
如果通过启动服务器，基于 Http 请求进行测试，这样会使得测试变得很麻烦，比如，启动速度慢，测试验证不方便，依赖网络环境等，这样会导致测试无法进行，
为了可以对 AOI 进行测试，可以通过引入 Spring-Test 进行解决。Spring-Test 模块构建在一个 Servlet API 模拟对象上，使用 DispatcherServlet 提供完整的 SpringMVC 运行时，
并不会使用正在运行的 Servlet 容器。通过 @ContextConfiguration 注解加载 SpringMVC 配置，该框架加载 Spring 配置并将 WebApplicationContext 注入测试以用于构建 MockMvc 实例。
```java
@WebAppConfiguration
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring-mvc-config.xml")
public class MessageControllerTests {
    @Resource
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }
}
```
可以为所有的测试设置通用的 Accept 和响应头，避免在每个接口的测试中都重复编写。
```java
this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext)
.defaultRequest(get("/").accept(MediaType.APPLICATION_JSON_UTF8))
.alwaysExpect(status().isOk())
.alwaysExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
.build()
```
MockMvc实例可以执行任何Http请求，并提供了丰富的方法。为了快速编写，需要静态导入一些包，如：
```java
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
```
```java
mockMvc.perform(get("/messages").contentType(MediaType.APPLICATION_JSON_UTF8))
```
携带参数的 Get 请求
```java
mockMvc.perform(get("/messages/{id}", 100).contentType(MediaType.APPLICATION_JSON_UTF8))
mockMvc.perform(get("/messages?id={id}", 100).contentType(MediaType.APPLICATION_JSON_UTF8))
```
Post 请求
```java
String requestBody = "{ \"nickname\": \"vincent\", \"content\": \"hello world\" }";
mockMvc.perform(
        post("/messages").contentType(MediaType.APPLICATION_JSON_UTF8)
        .content(requestBody)
    )
```
添加请求头
```java
mockMvc.perform(
        get("/messages").contentType(MediaType.APPLICATION_JSON_UTF8)
        .header(HttpHeaders.AUTHORIZATION, "425a00d6682b43c590ab24af05674c58")
    )
```
打印请求日志
```java
mockMvc.perform(get("/messages").contentType(MediaType.APPLICATION_JSON_UTF8))
    .andDo(print())
```
获取接口返回的响应结果
```java
String responseBody = mockMvc.perform(get("/messages").contentType(MediaType.APPLICATION_JSON_UTF8))
    .andReturn()
    .getResponse()
    .getContentAsString()
```
对返回的状态码进行断言
```java
mockMvc.perform(get("/messages").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                
mockMvc.perform(post("/messages").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isBadRequest())
```
使用 JSONPATH 对返回的内容进行断言。JSONPATH 是一个从 JSON 中抽取指定信息的工具类库，提供了多个语言的版本，不仅限于 Java。JSONPATH 对于 JSON 来讲，
相当于 XPATH 对于 XML，其语法也有相同之处。总体来讲，JSONPATH 可以简单快速获取 JSON 中任意层级中的属性值，也可以通过复合的查询条件来查询匹配的元素。
添加 JSONPATH 的依赖
```xml
<!-- JSONPAHT -->
<dependency>
    <groupId>com.jayway.jsonpath</groupId>
    <artifactId>json-path</artifactId>
    <version>2.4.0</version>
</dependency>
<!-- JSONPAHT 断言工具类 -->
<dependency>
    <groupId>com.jayway.jsonpath</groupId>
    <artifactId>json-path-assert</artifactId>
    <version>0.8.1</version>
    <scope>test</scope>
</dependency>
```
使用 JSONPATH 进行属性查询并断言
```java
mockMvc.perform(get("/messages").contentType(MediaType.APPLICATION_JSON_UTF8))
    .andExpect(jsonPath("$", hasSize(2)))
    .andExpect(jsonPath("$[0].nickname", is("vincent")))
    .andExpect(jsonPath("$[1].nickname", is("alice")))
    .andExpect(jsonPath("$[0].content", is("this is test message")))
    .andExpect(jsonPath("$[1].content", is("this is test message")))
    
// 预期返回的结果如下：
[
  { 
    uuid: '90dfe469500a4bc7825a0ff9fd196255', 
    nickname: 'vincent', 
    content: 'this is test message', 
    createdTime: '2018-11-04 00:01:49', 
    updatedTime: '2018-11-04 00:01:49',
  },
  { 
    uuid: '425a00d6682b43c590ab24af05674c58', 
    nickname: 'alice', 
    content: 'this is test message', 
    createdTime: '2018-11-04 00:01:49', 
    updatedTime: '2018-11-04 00:01:49',
  }
]
```
