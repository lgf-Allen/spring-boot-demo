/**
 * 
 */
package com.allen.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author first
 *
 */
@RestController
@RequestMapping(path="/hello")
public class HelloController {

    @GetMapping
    public String hello() {
        return "hello boot";
    }
}
