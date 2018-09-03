package com.allen.spring.boot;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class SpringBootThreadApplication {

	public static void main(String[] args) throws InterruptedException {
//		SpringApplication.run(SpringBootThreadApplication.class, args);
		Thread thread = new Thread(() -> {
			System.out.println("I will start work.");
//			while(!Thread.currentThread().isInterrupted()) {
//				
//			}
			for(; ;) {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					break;
				}
			}
			System.out.println("I will be exiting.");
		}) ;
		thread.start();
		TimeUnit.SECONDS.sleep(1);
		System.out.println("System will be shutdown.");
		thread.interrupt();
	}
}
