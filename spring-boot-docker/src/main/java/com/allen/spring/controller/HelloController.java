/**
 * 
 */
package com.allen.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author first
 *
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String home() {
        return "Hello Docker World";
    }

}
