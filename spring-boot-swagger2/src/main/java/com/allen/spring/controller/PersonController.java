/**
 * 
 */
package com.allen.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.allen.spring.bean.Person;

import io.swagger.annotations.ApiOperation;

/**
 * @author first
 *
 */
@RestController
public class PersonController {

    private static Logger logger = LoggerFactory.getLogger(PersonController.class);
    
    @ApiOperation(value="This is a swagger2 example.",notes="allen")
    @GetMapping(path="/person")
    public Person findOne(@RequestParam(value="name") String name) {
        logger.info("RequestParameter name value is {}" , name);
        Person person = new Person();
        person.setName(name);
        return person;
    }
}
