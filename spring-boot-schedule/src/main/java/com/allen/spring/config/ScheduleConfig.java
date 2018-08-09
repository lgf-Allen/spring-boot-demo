/**
 * 
 */
package com.allen.spring.config;

import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author first
 * 
 */
@Configuration
@EnableScheduling
public class ScheduleConfig {

    @Scheduled(cron="0/10 * * * * *")
    public void test1() {
        System.out.println("每隔10s打印一次,"+new Date());
    }
    
    @Scheduled(cron="0 0/1 * * * *")
    public void test2() {
        System.out.println("每隔1min打印一次,"+new Date());
    }
    
    @Scheduled(fixedDelay=3000)
    public void test3() {
    	System.out.println("上一个任务执行结束后，延迟3s执行下一次." +new Date());
    }
    
    @Scheduled(fixedRate=5000)
    public void test4() throws InterruptedException {
    	System.out.println("无论上一个任务是否执结束，延迟5s执行下一次." + new Date());
    }
    
}
