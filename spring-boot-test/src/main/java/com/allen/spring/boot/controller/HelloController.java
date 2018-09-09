/**
 * 
 */
package com.allen.spring.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Allen
 * @since 2018/9/9 15:15 
 */
@RestController
public class HelloController {
	
	@GetMapping(path = "/hello")
	public String hello() {
		return "Hello Jenkins";
	}
}
