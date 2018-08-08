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
}
