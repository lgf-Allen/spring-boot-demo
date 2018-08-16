# Change Spring Boot embedded server:tomcat --> jetty
## 1 新建一个springboot项目

## 2 pom.xml添加如下配置即可

```
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
			<exclusions>
				<exclusion>
					<groupId>org.springframework.boot</groupId>
					<artifactId>spring-boot-starter-tomcat</artifactId>
				</exclusion>
			</exclusions>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-jetty</artifactId>
		</dependency>
```

## 3 在applicaion.properties可以对jetty进行一些参数配置;或者在JettyConfig使用java config 方式也可以进行配置。
* application.properties

```
server.port=8001
```

* Java config

```
@Configuration
public class JettyConfig {

	@Bean
	public JettyEmbeddedServletContainerFactory  jettyEmbeddedServletContainerFactory() {
	    JettyEmbeddedServletContainerFactory jettyContainer =
	        new JettyEmbeddedServletContainerFactory();
	      
	    jettyContainer.setPort(9000);
//	    jettyContainer.setContextPath("/home");
	    return jettyContainer;
	}
}

```