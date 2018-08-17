package com.allen.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication(exclude = { /*DataSourceAutoConfiguration.class ,HibernateJpaAutoConfiguration.class*/})
public class SpringBootHelloApplication extends SpringBootServletInitializer implements WebApplicationInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHelloApplication.class, args);
	}
}
