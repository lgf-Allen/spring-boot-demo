/**
 * 
 */
package com.allen.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    
    /**
     * '@Value'支持两种表达式
     * 1.PlaceHolder方式：@value("${person.age}")
     * 2.Spring Expression Language：@value("#{person.age}")
     */
    @Value("#{person.age}")
    private int age;
    
    @GetMapping(path="/hello")
    public String hello() {
        System.out.println(age);
        return person.getName();
    }
}
