package com.allen.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
//@ComponentScan({"com.allen.spring.security"})
@EnableResourceServer 
public class SpringBootResourceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootResourceServerApplication.class, args);
	}
}
