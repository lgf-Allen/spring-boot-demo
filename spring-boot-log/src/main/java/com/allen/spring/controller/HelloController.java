/**
 * 
 */
package com.allen.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author first
 *
 */
@RestController
public class HelloController {

    private static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping(path = "/hello")
    public String hello() {
        logger.info("-------------------Info log.");
        logger.debug("-------------------Debug log.");
        logger.error("-------------------Error log.");
        return "Hello boot!";
    }
}
