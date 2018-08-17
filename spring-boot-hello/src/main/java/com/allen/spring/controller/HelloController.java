/**
 * 
 */
package com.allen.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allen.spring.bean.Person;

/**
 * @author first
 *
 */
@RestController
public class HelloController {

    
    @Autowired
    private Person person;
    
    @GetMapping(path="/hello")
    public String hello() {
        return person.getName();
    }
}
