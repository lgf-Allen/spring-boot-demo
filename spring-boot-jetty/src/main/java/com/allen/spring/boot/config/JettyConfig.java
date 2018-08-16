/**
 * 
 */
package com.allen.spring.boot.config;

import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author meng
 *
 */
@Configuration
public class JettyConfig {

	@Bean
	public JettyEmbeddedServletContainerFactory  jettyEmbeddedServletContainerFactory() {
	    JettyEmbeddedServletContainerFactory jettyContainer =
	        new JettyEmbeddedServletContainerFactory();
	      
	    jettyContainer.setPort(9000);
//	    jettyContainer.setContextPath("/home");
	    return jettyContainer;
	}
}
