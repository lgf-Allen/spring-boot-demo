# Spring Boot 集成 Schedule
* 常用的定时器有JDK自带的Timer,可以让程序在某一频率执行,缺点是不能指定执行时间
* Spring 3以后出现的Task:大部分情况下都可以使用,日常项目中较多采用,缺点是集群环境下会出现重复执行Task
* Quartz: Quartz是OpenSymphony开源组织在Job scheduling领域又一个开源项目,多用于复杂集群环境下的任务调度,缺点是配置稍显复杂。
> 本文主要介绍Spring Task和Spring Boot项目的集成

## 1.1 新建一个Spring Boot项目,`pom.xml`包括`spring-boot-starter-web`即可
## 1.2 新建一个  `ScheduleConfig`,添加`@Configuration`和`@EnableScheduling`,这样基本的配置就结束了。

    @Configuration
    @EnableScheduling
    public class ScheduleConfig {
    
    }
## 1.3 在项目中使用定时器

    @Configuration
    @EnableScheduling
    public class ScheduleConfig {
        //每隔10s执行一次
        @Scheduled(cron="0/10 * * * * *")
        public void test1() {
            System.out.println("每隔10s打印一次,"+new Date());
        }
        //每隔1min执行一次
        @Scheduled(cron="0 0/1 * * * *")
        public void test2() {
            System.out.println("每隔1min打印一次,"+new Date());
        }
    
    }
> 启动Spring Boot,控制台输入如下图所示

![schedule.jpg](src/main/webapp/image/schedule.jpg)
## 1.4 FAQ
* 上图中出现的定时任务执行时间是根据当前服务器系统时间进行计算的，比如服务器启动时,服务器时间是`10:58:09`,时间就会首先到达 `10:58:10`执行一次`test1()`,然后`10:58:20`,`10:58:30`,`10:58:40`...都执行一次`test1()`,直到到达`10:59:00`会执行一次`test2()`
* cronExpression

|     name    |   Required   |   Allowed Values   |  Allow Special Characters  |
|:-----------:|:------------:|:------------------:|:--------------------------:|
|    Seconds  |     Y        |       0-59         |        ,-*/                |
|    Minutes  |     Y        |       0-59         |        ,-*/                |
|    Hours    |     Y        |       0-23         |        ,-*/                |
| Day of month|     Y        |       1-31         |        ,-*/? L W C         |
|    Month    |     Y        |  0-11 or JAN-DEC   |        ,-*/                |
| Day of week |     Y        |   1-7 or SUN-SAT   |      ,-*/? L C #           |
|    Year     |     N        | empty or 1970-2099 |        ,-*/                |
* example
	* `0 0 12 * * ?`--------------------`每天下午12点执行`
	* `0 15 10 ? * *`----------------------`每天上午10点15分执行`
	
## 1.5 Tools
* 自动生成cron表达式:[http://cron.qqe2.com/](http://cron.qqe2.com/)

## 2.1 JDK自带的Timer的使用
```
public static void main(String[] args) {
        Timer timer = new Timer("MyTimer"); <1>
        timer.schedule(new TimerTask() {
            int i = 0 ;
            @Override
            public void run() {
                ++ i;
                System.out.println(" Timer execute "+ i +"次,Now timeStamp is "+ System.currentTimeMillis());
            }
        }<2>,  2000l <3>, 3000l<4>);

    }
```

* <1> 创建一个name叫 `MyTimer`的Timer实例
* <2> 定义一个匿名内部类实现TimerTask抽象类的抽象方法run(),在run()方法中自定义定时任务;TimerTask类实现了Runnable接口
* <3> 调用schedule()后,到调用run()方法之间的延迟时间,值为`0`时表示没有延迟
* <4> 第一次调用之后，从第二次开始每隔多长的时间调用一次 run()方法

> 执行上面的main()方法,控制台输出如下:

```
Timer execute 1次,Now timeStamp is 1534925391431
Timer execute 2次,Now timeStamp is 1534925394431
Timer execute 3次,Now timeStamp is 1534925397431
Timer execute 4次,Now timeStamp is 1534925400432
Timer execute 5次,Now timeStamp is 1534925403432
```
## 2.2 常用的一些时间戳转Data在线工具
* [https://tool.lu/timestamp](https://tool.lu/timestamp)
