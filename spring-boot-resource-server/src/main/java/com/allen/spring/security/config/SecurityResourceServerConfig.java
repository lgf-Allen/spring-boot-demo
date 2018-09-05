/**
 * 
 */
package com.allen.spring.security.config;

import org.apache.catalina.filters.RequestDumperFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author first
 *
 */
@Configuration
public class SecurityResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Bean
    RequestDumperFilter requestDumperFilter() {
        return new RequestDumperFilter();
    }
    
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/demo")
                .access("#oauth2.hasScope('read')");      // require 'read' scope to access /demo URL
    }
   
}
