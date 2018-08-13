# Spring Boot integration swagger2

## 1 `pom.xml`引入依赖

        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>${swagger.version}</version>
        </dependency>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>${swagger.version}</version>
        </dependency>

## 2 添加swagger configuraiton类

        @Configuration
        @EnableSwagger2
        public class Swagger2Configuration {
        
            @Bean
            public Docket productApi() {
                return new Docket(DocumentationType.SWAGGER_2)
                        .apiInfo(apiInfo())
                        .select()
                        .apis(RequestHandlerSelectors
                        .basePackage("com.allen.spring.controller"))
                        .paths(PathSelectors.any())
                        .build();
            }
        
            private ApiInfo apiInfo() {
                return new ApiInfoBuilder()
                        .title("Spring Boot中使用Swagger2构建Restful APIs")
                        .description("This is my first demo")
                        .termsOfServiceUrl("http://localhost:8080/")
                        .contact(new Contact("Allen", "http://xxx.com", "Allen@xxx.com"))
                        .version("v1.0")
                        .build();
            }
        
        }

## 3 参考文章
* [参考文章1](https://mp.weixin.qq.com/s?__biz=MzA4ODIyMzEwMg==&mid=2447533616&idx=1&sn=269192a16202aadbcafd580a0c7c2cc7&chksm=843bba21b34c33378967e40623695dfb38374ecd697b2164bedb1cca28e26852e53629339371&mpshare=1&scene=1&srcid=0808yzl9aBKnkwR3KMKOxx2X#rd)
* [参考文章2](https://mp.weixin.qq.com/s?__biz=MzA4ODIyMzEwMg==&mid=2447533624&idx=1&sn=3d21a5122afd05b85d19c209b1f6a326&chksm=843bba29b34c333fe7d79cceb3c94a5bb0819cb5c47245ba5ce6adde52ebec133a08bbf03c1b&mpshare=1&scene=1&srcid=08083Od3hEze7tchMVwd5WFK#rd)