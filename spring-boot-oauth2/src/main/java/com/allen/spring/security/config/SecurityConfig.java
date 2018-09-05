/**
 * 
 */
package com.allen.spring.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author first
 *
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter  {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/", "/login**")
                .permitAll()
                .anyRequest()
                .authenticated();
    }
    
    // here is configuration related to spring boot basic authentication
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            // static users
            .withUser("zone1").password("mypassword").roles("USER")
            .and()
            .withUser("zone2").password("mypassword").roles("USER")
            .and()
            .withUser("zone3").password("mypassword").roles("USER")
            .and()
            .withUser("zone4").password("mypassword").roles("USER")
            .and()
            .withUser("zone5").password("mypassword").roles("USER");
    }
}
