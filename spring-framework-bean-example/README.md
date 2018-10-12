# spring-framework-bean-example
```java
// 自动扫描当前包下的组件
@ComponentScan

// 扫描一个或多个制定包下的组件
@ComponentScan(basePackages = { "com.vincent.spring.framework.example.web", "com.vincent.spring.framework.example.service" })

// 扫描指定类所在的包
@ComponentScan(basePackageClasses = com.vincent.spring.framework.example.SpringContextConfig.class)
```

```xml
<!-- 扫描一个或多个制定包下的组件 -->
<!-- 与 Java 配置不同，使用 XML 配置必须指定扫描包的范围 -->
<context:component-scan base-package="com.vincent.spring.framework.example"/>
```

```java
// 声明一个组件
@Component

// 声明一个组件并设置它的ID
@Component("foo")
```

```xml
<!-- 声明一个 JavaBean -->
<bean id="foo" class="com.vincent.spring.Foo"/>

<!-- 声明一个 JavaBean 并注入构造参数 -->
<bean id="dataSource" class="com.vincent.spring.DataSource">
    <constructor-arg value="root"/>
    <constructor-arg value="root"/>
</bean>

<!-- 指定参数名称进行装配 -->
<bean id="dataSource" class="com.vincent.spring.DataSource">
    <property name="username" value="root"/>
    <property name="password" value="root"/>
</bean>

<!-- 装配构造函数参数是 List 类型的 JavaBean -->
<bean id="foo" class="com.vincent.spring.Foo">
    <constructor-arg>
        <list>
            <value>100</value>
            <value>200</value>
            <value>300</value>
        </list>
    </constructor-arg>
</bean>

<!-- 装配构造函数参数是 Set 类型的 JavaBean -->
<bean id="foo" class="com.vincent.spring.Foo">
    <constructor-arg>
        <set>
            <value>100</value>
            <value>200</value>
            <value>300</value>
        </set>
    </constructor-arg>
</bean>
```

```java
// 自动装配一个 JavaBean
@Resource

// 装配指定ID的 JavaBean
@Resource("foo")

// 通过构造函数装配 JavaBean
public class Foo {
    
    private Bar bar;
    
    @Autowired
    public Foo(Bar bar) {
        this.bar = bar;
    }
}

// 忽略没有找到的 JavaBean，但是这样做容易抛出 NPE
@Resource(required = false)
```
