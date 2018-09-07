/**
 * 
 */
package com.allen.spring.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.allen.spring.resolver.ClientInformationResolver;

/**
 * @author first
 *
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    
    @Bean
    public ClientInformationResolver clientInformationResolver() {
        return new ClientInformationResolver();
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //映射日志文件:http://localhost:8080/logs/spring-boot-swagger2.txt
        registry.addResourceHandler("logs/**").addResourceLocations("file:applog/logs/");
        //添加处理swagger静态页面的映射
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js/");
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
    
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        //Add @Client_information Resolver
        argumentResolvers.add(clientInformationResolver());
    }

}
