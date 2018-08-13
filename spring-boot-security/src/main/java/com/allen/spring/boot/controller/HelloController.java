/**
 * 
 */
package com.allen.spring.boot.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author first
 *
 */
@RestController
public class HelloController {

    @GetMapping(path="/test")
    public String hello() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        String username = null;
        if(principal instanceof UserDetails) {
             username = ((UserDetails)principal).getUsername();
        }else {
             username = principal.toString();
        }
        return "Hello " + username;
    }
}
