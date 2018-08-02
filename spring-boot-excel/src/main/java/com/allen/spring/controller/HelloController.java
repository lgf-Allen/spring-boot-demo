/**
 * 
 */
package com.allen.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author first
 *
 */
@RestController
public class HelloController {

    @GetMapping(path="/hello")
    public String hello() {
        return "Hello boot!";
    }
}
