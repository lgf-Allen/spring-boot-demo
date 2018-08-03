# Spring Boot 日志框架
> *Spring Boot* 内部采用的是 *Commons Logging* 进行日志记录，但在底层为 *Java Util Logging*、
> *Log4J2*、*Logback* 等日志框架提供了默认配置 。

## 1.1 Spring Boot 默认日志框架*Java Util Logging*
可在applicaiton.yml/application.properties中进行配置，如下所示列举了一些常用的配置

        # 配置log level
        logging.level.root = WARN
        # 配置自定义包下的日志级别
        logging.level.com.allen.spring.controller = DEBUG

