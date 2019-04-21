# *Spring Boot* 日志框架
> *Spring Boot* 内部采用的是 *Commons Logging* 进行日志记录，但在底层为 *Java Util Logging*、
> *Log4J2*、*Logback* 等日志框架提供了默认配置 。

## 1. *Spring Boot* 默认日志框架*Java Util Logging*
可在applicaiton.yml/application.properties中进行配置，如下所示列举了一些常用的配置
> 日志级别:ERROR、WARN、INFO、DEBUG、TRACE
```properties
# 配置log level
logging.level.root = WARN
# 配置自定义包下的日志级别(com.allen.spring.controller) 
logging.level.com.allen.spring.controller = DEBUG
# 默认情况下，日志只会输出到控制台中;指定日志输出文件 ，但此时日志依然会打印到控制台 
logging.file=${user.home}/logs/spring-boot-log.log
# 限制日志文件大小
logging.file.max-size=10MB
# 限制日志文件保留天数
logging.file.max-history=10

```
        
> 输出的日志文件路径如下图所示 

![logfile](src/test/resources/logfile.jpg)

## 2. *Spring Boot* 集成*Log4j2* 框架
### 2.1 首先在pom.xml引入如下依赖 (Note:去掉spring-boot-starter-logging的依赖)
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
        <exclusions>
            <!-- 去掉默认的logback -->
            <exclusion>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-logging</artifactId>
            </exclusion>
        </exclusions>
    </dependency>
    <!-- 引入log4j2 -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-log4j2</artifactId>
    </dependency>
</dependencies>
```
### 2.2. 在src/main/resources下引入*log4j2.xml*,相关配置如下
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!--Configuration > status设置log4j2的自身log级别-->
<!--Configuration > monitorInterval：修改配置文件时,Log4j自动刷新配置的间隔秒数-->
<!--日志级别以及优先级排序: OFF > FATAL > ERROR > WARN > INFO > DEBUG > TRACE > ALL -->
<Configuration status="INFO" monitorInterval="30" >
    <Properties>
    	<!-- 设置一个属性，代表项目名  -->
        <Property name="CONTEXTNAME">spring-boot-log</Property>
        <!-- 设置日志格式 -->
        <Property name="LOG_PATTERN" >%d ${CONTEXTNAME} [%thread] %-5level %logger{36} - %msg%n</Property>
    </Properties>
    <Appenders>
    	<!-- 输出到控制台 -->
        <Console name="STDOUT" target="SYSTEM_OUT">
            <PatternLayout pattern="${LOG_PATTERN}" />
        </Console>
         输出到文件
        <RollingFile name="RollingFile" fileName="applog/logs/${CONTEXTNAME}.txt"
            filePattern="${CONTEXTNAME}-%d{yyyy-MM-dd}-%i.txt">
            <PatternLayout pattern="${LOG_PATTERN}" />
            <Policies>
            	<!-- 触发归档策略 -->
                <TimeBasedTriggeringPolicy />
                <!-- 限制单个日志文件的大小 -->
                <SizeBasedTriggeringPolicy size="10MB" />
            </Policies>
            <!-- 循环归档策略  -->
            <DefaultRolloverStrategy max="100">
                <Delete basePath="applog/logs" maxDepth="1">
                    <IfFileName glob="${contextName}-*.txt">
                        <IfLastModified age="2m">
                            <IfAny>
                            	<!-- 执行循环删除的条件  -->
                                <IfAccumulatedFileSize exceeds="1GB" />
                                <IfAccumulatedFileCount exceeds="100" />
                            </IfAny>
                        </IfLastModified>
                    </IfFileName>
                </Delete>
            </DefaultRolloverStrategy>
        </RollingFile>
         <RollingFile name="RollingFileInfo" fileName="${user.home}/logs/${CONTEXTNAME}-info.txt"
             filePattern="applog/logs/${CONTEXTNAME}-info-%d{yyyy-MM-dd}-%i.txt">
             <Filters>
 				<!--控制台只输出level及以上级别的信息（onMatch），其他的直接拒绝（onMismatch）-->
                 <ThresholdFilter level="INFO" onMatch="ACCEPT" onMismatch="DENY"/>
             </Filters>
             <PatternLayout pattern="${LOG_PATTERN}" />
             <Policies>
                 <TimeBasedTriggeringPolicy />
                 <SizeBasedTriggeringPolicy size="10MB" />
             </Policies>
         </RollingFile>
         <RollingFile name="RollingFileDebug" fileName="applog/logs/${CONTEXTNAME}-debug.txt"
             filePattern="applog/logs/${CONTEXTNAME}-debug-%d{yyyy-MM-dd}-%i.txt">
             <Filters>
 				<!--控制台只输出level及以上级别的信息（onMatch），其他的直接拒绝（onMismatch）-->
                 <ThresholdFilter level="DEBUG" onMatch="ACCEPT" onMismatch="DENY"/>
             </Filters>
             <PatternLayout pattern="${LOG_PATTERN}" />
             <Policies>
                 <TimeBasedTriggeringPolicy />
                 <SizeBasedTriggeringPolicy size="10MB" />
             </Policies>
         </RollingFile>
         <RollingFile name="RollingFileError" fileName="applog/logs/${CONTEXTNAME}-error.txt"
             filePattern="applog/logs/${CONTEXTNAME}-error-%d{yyyy-MM-dd}-%i.txt">
             <Filters>
 				<!--控制台只输出level及以上级别的信息（onMatch），其他的直接拒绝（onMismatch） -->
                 <ThresholdFilter level="ERROR" onMatch="ACCEPT" onMismatch="DENY"/>
             </Filters>
             <PatternLayout pattern="${LOG_PATTERN}" />
             <Policies>
                 <TimeBasedTriggeringPolicy />
                 <SizeBasedTriggeringPolicy size="10MB" />
             </Policies>
         </RollingFile>
		<!-- 异步appender -->
        <Async name="Async">
            <AppenderRef ref="RollingFile" />
        </Async>
    </Appenders>
    <Loggers>
        <logger name="com.allen.spring.controller" level="info" ></logger>
        <Root level="info">
       		<!-- 打印到控制台  -->
            <appender-ref ref="STDOUT" />
            <!-- 使用异步方式打印日志到文件 -->
            <appender-ref ref="Async" />
            <!-- 使用filter 将不同级别的日志打印到不同的文件中  -->
 			<appender-ref ref="RollingFileInfo" />
 			<appender-ref ref="RollingFileDebug" />
 			<appender-ref ref="RollingFileError" />
        </Root>
    </Loggers>
</Configuration>

```
对应的输出日志如下：
[images/log.png](images/log.png)

### 2.3 更多关于log4j2的配置请参考官网
- [log4j2官网](http://logging.apache.org/log4j/2.x/manual/)

	


        

