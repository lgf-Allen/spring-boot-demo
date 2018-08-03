# *Spring Boot* 日志框架
> *Spring Boot* 内部采用的是 *Commons Logging* 进行日志记录，但在底层为 *Java Util Logging*、
> *Log4J2*、*Logback* 等日志框架提供了默认配置 。

## 1.1 *Spring Boot* 默认日志框架*Java Util Logging*
可在applicaiton.yml/application.properties中进行配置，如下所示列举了一些常用的配置
> 日志级别:ERROR、WARN、INFO、DEBUG、TRACE

        # 配置log level
        logging.level.root = WARN
        # 配置自定义包下的日志级别(com.allen.spring.controller) 
        logging.level.com.allen.spring.controller = DEBUG
        # 指定日志输出文件 ，但此时日志依然会打印到控制台 
        logging.file=${user.home}/logs/spring-boot-log.log
        
![logfile](src/test/resouces/logfile.jpg)
        

