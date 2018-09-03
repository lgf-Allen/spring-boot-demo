/**
 * 
 */
package com.allen.spring.boot.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.allen.spring.boot.config.filter.CustomerFilter;

/**
 * @author meng
 *
 */
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/test").hasRole("USER")
            .anyRequest()
            .fullyAuthenticated()
            .and()
//            .addFilterAfter(customerFilter(), BasicAuthenticationFilter.class)
            .httpBasic();
        http.cors().disable();
        
        http.logout().logoutUrl("/logout")
                     .logoutSuccessUrl("/test");
    }
    
    @Autowired
    private DataSource dataSource;
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.
            jdbcAuthentication()
            .dataSource(dataSource)
//            .withDefaultSchema()
            .withUser("Allen")
            .password("password")
            .roles("USER");
    }
    
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("Allen").password("password").roles("USER").and()
//                .withUser("Admin").password("admin").roles("ADMIN");

//    }
    
//    @Bean
//    public CustomerFilter customerFilter() {
//        return new CustomerFilter();
//    }
    
}
