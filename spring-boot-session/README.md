# Session 与 Cookie

## 

## 去除springboot禁用特定的自动配置项
> 方法一：在主类的*@SpringBootApplication*加上exclude属性,比如去掉DataSourceAutoConfiguration

    @SpringBootApplication(exclude = { DataSourceAutoConfiguration.class ,HibernateJpaAutoConfiguration.class})
    public class SpringBootSessionApplication {
        
        public static void main(String[] args) {
            SpringApplication.run(SpringBootSessionApplication.class, args);
        }
    }

> 方法二：在application.yml或者application.properties添加如下配置

        spring.autoconfigure.exclude[0]=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
        spring.autoconfigure.exclude[1]=org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration
        