package com.allen.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.allen.spring.security.config"})
public class SpringBootOauth2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOauth2Application.class, args);
	}
}
