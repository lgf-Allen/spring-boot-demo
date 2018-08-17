# Spring Boot 
> 这个demo主要包括三部分:自定义配置文件,禁用特定的自动配置项,Spring Rest Docs

**首先,新建一个spring boot项目**

## 1 使用java bean自定义配置文件
### 1.1 新建一个java bean,添加`@Component`和`@ConfigurationProperties(prefix = "person")`
```
@Component
@ConfigurationProperties(prefix = "person")
public class Person {

    private String name;
    private Integer age;
    ...
    }
```

### 1.2 application.yml配置属性值
```
person: 
  name: lisi
```

### 1.3 在controller中获取application.yml中配置的属性值
```
@RestController
public class HelloController {

    
    @Autowired
    private Person person;
    
    @GetMapping(path="/hello")
    public String hello() {
        return person.getName();
    }
}
```
### 1.4 访问`http://localhost:8080`就可以看到配置是否生效

## 2 禁用特定的自动配置项
### 2.1 方法一：在主类的*@SpringBootApplication*加上exclude属性,比如去掉*DataSourceAutoConfiguration*和*HibernateJpaAutoConfiguration*
```
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class ,HibernateJpaAutoConfiguration.class})
public class SpringBootHelloApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(SpringBootHelloApplication.class, args);
    }
}
```
### 2.2 方法二：在application.yml或者application.properties添加如下配置
```
spring.autoconfigure.exclude[0]=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
spring.autoconfigure.exclude[1]=org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration
```

## 3 Spring Rest Docs

### 3.1 添加依赖和插件
```
<!-- mockmvc -->
<dependencies>
	<dependency>
	    <groupId>org.springframework.restdocs</groupId>
	    <artifactId>spring-restdocs-mockmvc</artifactId>
	    <scope>test</scope>
	</dependency>
</dependencies>

<build>
	<plugins>
		<!-- asciidoc plugin:将.adoc文件转化成html -->
		<plugin>
			<groupId>org.asciidoctor</groupId>
			<artifactId>asciidoctor-maven-plugin</artifactId>
			<executions>
				<execution>
					<id>generate-docs</id>
					<phase>prepare-package</phase>
					<goals>
						<goal>process-asciidoc</goal>
					</goals>
					<configuration>
						<backend>html</backend>
						<doctype>book</doctype>
					</configuration>
				</execution>
			</executions>
			<dependencies>
				<dependency>
					<groupId>org.springframework.restdocs</groupId>
					<artifactId>spring-restdocs-asciidoctor</artifactId>
					<version>1.2.0.RELEASE</version>
				</dependency>
			</dependencies>
		</plugin>
	</plugins>
</build>
		
```
