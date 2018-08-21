package com.allen.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages =  {"com.allen.spring.oracle.repository.*"} , repositoryImplementationPostfix = "Impl")
@SpringBootApplication
public class SpringBootOracleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOracleApplication.class, args);
	}
}
