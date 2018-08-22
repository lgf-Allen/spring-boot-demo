package com.allen.spring;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootScheduleApplication {

	public static void main(String[] args) {
	    //timerSample();//开启timer测试
		SpringApplication.run(SpringBootScheduleApplication.class, args);
		
	}
	
	/**
	 * JDK Timer Sample. 
	 */
	public static void timerSample() {
	    Timer timer = new Timer("MyTimer");
        timer.schedule(new TimerTask() {
            int i = 0 ;
            @Override
            public void run() {
                ++ i;
                System.out.println(" Timer execute "+ i +"次,Now timeStamp is "+ System.currentTimeMillis());
            }
        },  2000l , 3000l);
	}
}
