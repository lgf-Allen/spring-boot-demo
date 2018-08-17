/**
 * 
 */
package com.allen.spring.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.allen.spring.bean.User;

/**
 * @author first
 *
 */
@RestController
@RequestMapping(path = "/users")
public class UserController {

    @GetMapping()
    public ResponseEntity<User> findUser(@RequestParam(value = "userId") Long userId) {
        User user = new User();
        user.setUserId(userId);
        user.setName("Lisi");
        user.setAge(25);
        // Self link
        // Link selfLink = ControllerLinkBuilder
        // .linkTo(UserController.class)
        // .slash(user.getUserId())
        // .withSelfRel();
        // user.add(selfLink);
        user.add(linkTo(methodOn(UserController.class).findUser(userId)).withSelfRel());
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
    
    @GetMapping(path="/{name}")
    public ResponseEntity<User> findByName( String name) {
        User user = new User();
        user.setName("Allen");
        user.setAge(25);
        user.add(linkTo(methodOn(UserController.class).findByName(name)).withSelfRel());
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }


}
