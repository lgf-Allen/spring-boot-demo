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
