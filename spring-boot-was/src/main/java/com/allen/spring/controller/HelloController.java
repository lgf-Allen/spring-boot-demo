package com.allen.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author first
 *
 */
@RestController
public class HelloController {

    @RequestMapping(path = "/hello")
    public String loginPage() {
        return "hello boot!";
    }
}
