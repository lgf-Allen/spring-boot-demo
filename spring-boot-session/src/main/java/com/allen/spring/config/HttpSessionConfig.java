/**
 * 
 */
package com.allen.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author first
 *
 */
@Configuration
@EnableRedisHttpSession
public class HttpSessionConfig {

}
